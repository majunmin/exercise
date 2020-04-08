package com.mjm.lock.reentrant;

public class SyncchronizedTest implements Runnable {

    public synchronized void get() {
        System.out.println(Thread.currentThread().getId());
        set();
    }

    public synchronized void set() {
        System.out.println(Thread.currentThread().getId());
    }

    @Override
    public void run() {
        get();
    }

    public static void main(String[] args) {
        SyncchronizedTest ss = new SyncchronizedTest();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
    }

}
