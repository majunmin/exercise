package com.mjm.ratelimit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * guava 实现令牌桶算法 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-09-07 20:15
 * @since
 */
public class GuavaLimit {

    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(5);
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
    }
}
