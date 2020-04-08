package com.mjm.cache;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.Configuration;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-09-12 19:28
 * @since
 */
public class App {

    public static void main(String[] args) {

        CachingProvider cachingProvider = Caching.getCachingProvider();
        CacheManager cacheManager = cachingProvider.getCacheManager();

        Cache<String, User> cache = cacheManager.<String, User, Configuration<String, User>>createCache("Test", new MutableConfiguration<String, User>());
        cache.put("majm", new User());
        System.out.println(cache.get("majm"));
    }
}
