package com.mjm.lock.reentrant;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁 </br>
 *
 * 这样实现自旋锁有2个问题
 *  1. 当同一个线程第二次调用 lock() 时（在第一次调用lock() 且 unlock()之前)
 *     会一直等待,导致死锁
 *
 *     ** 解决办法 见SpinLock2 第二次 lock() 时 进行判断当前线程是否已经获取过锁，如果获取过锁直接返回 ()
 *  2. 自旋锁
 *     多次 lock() 只其实只需要 一次解锁， 设置变量 count 记录 加锁次数
 * @author majunmin
 * @description
 * @datetime 2019/10/23 4:24 下午
 * @since
 */
public class SpinLock1 {

    /**
     * 拥有锁的线程
     */
    private AtomicReference<Thread> owner = new AtomicReference<>();

    public void lock() {
        Thread currentThread = Thread.currentThread();
        // 如果没获取到锁，则通过CAS自旋
        while (!owner.compareAndSet(null, currentThread)) {
        }
    }

    public void unlock() {
        Thread currentThread = Thread.currentThread();
        owner.compareAndSet(currentThread, null);
    }

}
