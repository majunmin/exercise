package com.mjm.lock.reentrant;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自旋锁 公平锁 </br>
 *
 * (释放锁的时候需要传入排队号,会有风险)
 * 线程获取锁之后，将它的排队号返回，等该线程释放锁的时候，需要将该 ==>排队号<==传入。
 * 但这样是有风险的，因为这个 排队号 是可以被修改的，一旦 排队号 被不小心修改了，那么锁将不能被正确释放。
 *
 * @author majunmin
 * @description
 * @datetime 2019/10/23 5:41 下午
 * @since
 */
public class TicketLock1 {

    /**
     * 服务号
     */
    private AtomicInteger serverNum = new AtomicInteger();
    /**
     * 排队号
     */
    private AtomicInteger ticketNum = new AtomicInteger();

    /**
     *
     * 获取锁
     * 如果获取锁成功 就返回当前线程排队号,排队号用于释放锁
     */
    public int lock(){
        int curTicketNum = ticketNum.getAndIncrement();
        while(curTicketNum != serverNum.get()){

        }
        return curTicketNum;
    }

    /**
     * 释放锁
     * 传入当前持有锁的线程排队号
     */
    public void unlock(int ticketNum){
        serverNum.compareAndSet(ticketNum, ticketNum + 1);
    }


}
