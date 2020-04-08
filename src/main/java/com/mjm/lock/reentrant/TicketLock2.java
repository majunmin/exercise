package com.mjm.lock.reentrant;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自旋锁 公平锁 </br>
 *
 * 将每个线程的排队号放到了ThreadLocal中。
 *
 * 在多核处理器里
 *  每个进程/线程 占用处理器都在去读写同一个变量， serverNum,
 *  每次读写都必须在多个处理器间进行缓存同步,这会导致频繁的系统总线和内存流量,大大降低系统整体性能
 *
 * @author majunmin
 * @description
 * @datetime 2019/10/23 5:47 下午
 * @since
 */
public class TicketLock2 {

    /**
     * 服务号
     */
    private AtomicInteger serverNum = new AtomicInteger();
    /**
     * 排队号
     */
    private AtomicInteger ticketNum = new AtomicInteger();

    /**
     * 创建一个 ThreadLocal 用于 存储每个线程的 ticketNum
     */
    private ThreadLocal<Integer> ticketNumHolder = new ThreadLocal<>();

    /**
     *
     * 获取锁
     * 如果获取锁成功 就返回当前线程排队号,排队号用于释放锁
     */
    public int lock(){
        int curTicketNum = ticketNum.getAndIncrement();
        // 获取锁的时候，将当前线程的排队号保存起来
        ticketNumHolder.set(curTicketNum);
        while(curTicketNum != serverNum.get()){

        }
        return curTicketNum;
    }

    /**
     * 释放锁
     * 传入当前持有锁的线程排队号
     */
    public void unlock(){
        Integer curTicketNum = ticketNumHolder.get();
        serverNum.compareAndSet(curTicketNum, curTicketNum + 1);
    }


}
