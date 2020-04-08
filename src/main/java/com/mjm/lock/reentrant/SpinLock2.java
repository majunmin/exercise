package com.mjm.lock.reentrant;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019/10/23 4:24 下午
 * @since
 */
public class SpinLock2 {

    /**
     * 拥有锁的线程
     */
    private AtomicReference<Thread> owner = new AtomicReference<>();

    private int count = 0;

    public void lock() {
        Thread currentThread = Thread.currentThread();
        if(currentThread == owner.get()){
            count ++;
            return;
        }
        // 如果没获取到锁，则通过CAS自旋
        while (!owner.compareAndSet(null, currentThread)){

        }
    }

    public void unlock(){
        Thread currentThread = Thread.currentThread();
        if (currentThread == owner.get()){
            if (count != 0){ // 如果大于0，表示当前线程多次获取了该锁，释放锁通过count减一来模拟
                count--;
            } else { // 如果count==0，可以将锁释放，这样就能保证获取锁的次数与释放锁的次数是一致的了
                owner.compareAndSet(currentThread, null);
            }
        }
    }

}
