package com.mjm.lock.reentrant;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * 自旋锁 </br>
 *
 * CLH锁是一种基于链表的可扩展、高性能、公平的自旋锁，申请线程只在本地变量上自旋，它不断轮询前驱的状态，如果发现前驱释放了锁就结束自旋，获得锁。
 *
 * @author majunmin
 * @description
 * @datetime 2019/10/23 6:03 下午
 * @since
 */
public class CLHLock {

    /**
     * 定义一个节点 默认lock状态 = true
     */
    public static class CLHNode{
        private volatile boolean isLocked = Boolean.TRUE;
    }

    // 尾部节点
    private CLHNode tail;
    private static final ThreadLocal<CLHNode> LOCAL = new ThreadLocal<>();
    private static final AtomicReferenceFieldUpdater<CLHLock, CLHNode> UPDATER =
            AtomicReferenceFieldUpdater.newUpdater(CLHLock.class, CLHNode.class, "tail");

    public void lock(){
        // 新建节点并将节点与当前线程保存下来
        CLHNode node = new CLHNode();
        LOCAL.set(node);
        // 将新建的节点设置为 尾部节点, 并返回旧的节点(原子操作),这里的旧节点实际上就是当前节点的前驱节点
        CLHNode preNode = UPDATER.getAndSet(this, node);
        if (Objects.nonNull(preNode)){
            // preNode != null 表当锁被其他线程占用，通过不断轮询判断前驱节点的锁标志位等待前驱节点释放锁
            while(preNode.isLocked){

            }
            preNode = null;
            // 如果不存在前驱节点，表示该锁没有被其他线程占用，则当前线程获得锁
            LOCAL.set(node);
        }
        // 如果不存在前驱节点，表示该锁没有被其他线程占用，则当前线程获得锁
    }

    public void unlock(){
        // 获取当前线程对应的节点
        CLHNode node = LOCAL.get();
        // 如果 tail == node, 则将 tail 节点更新为 null,
        // 同时将 node.isLocked 置为 false, 表示当前线程释放了锁
        if (!UPDATER.compareAndSet(this, node, null)){
            node.isLocked = Boolean.FALSE;
        }
        node = null;
    }






}
