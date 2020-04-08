package com.mjm;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
 * @datetime 2019-02-19 17:40
 * @since
 */
public class CacheTest {

    public static void main(String[] args) {
        //获取缓存提供层对象
        CachingProvider cachingProvider = Caching.getCachingProvider();

        //获取缓存管理层对象
        CacheManager manager = cachingProvider.getCacheManager();

        //创建缓存实例对象
        Cache<String, User> cache = (Cache<String, User>) manager.<String, User, Configuration<String, User>>
                createCache("Test", new MutableConfiguration<String, User>());

        String key = "leo";

        User user = new User();
        user.setName("leo");

        //将User数据对象存放到缓存中
        cache.put(key, user);

        System.out.println("Hello " + cache.get(key).getName());

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class User{
        private String name;
    }
}
