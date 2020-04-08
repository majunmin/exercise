package com.mjm.lock.reentrant;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019/10/23 4:49 下午
 * @since
 */
public class TestMain {

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("pool-%d").build();
    private static ExecutorService pool = new ThreadPoolExecutor(10, 10,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory);

    public static void main(String[] args) {
        SpinLock1 spinLock = new SpinLock1();
        spinLock.lock();
        spinLock.lock();
        spinLock.lock();
        spinLock.lock();

        spinLock.unlock();



        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
