package com.mjm.lock.reentrant;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;

/**
 * 可重入锁 </br>
 *
 * 可重入锁 最大的作用就是避免死锁
 *
 * @author majunmin
 * @description
 * @datetime 2019/10/23 4:08 下午
 * @since
 */
public class ReentrantLockTest implements Runnable {


//    ReentrantLock lock = new ReentrantLock();
//    SpinLock1 lock = new SpinLock1();
    SpinLock2 lock = new SpinLock2();

    public static void main(String[] args) {
        ReentrantLockTest rlt = new ReentrantLockTest();

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("pool-%d").build();
        ExecutorService pool = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory);

        IntStream.rangeClosed(0, 50)
                .forEach(i -> pool.execute(rlt));

        pool.shutdown();//gracefully shutdown

    }

    @Override
    public void run() {
        get();
    }

    private void get() {
        lock.lock();
        System.out.println(currentThread().getName() + "获得锁");
        set();
        lock.unlock();
    }

    private void set() {
        lock.lock();
        System.out.println(currentThread().getName() + "获得锁");
        lock.unlock();
    }


}
