package com.mjm.ehcache;


import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;

import java.net.URL;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019/10/14 5:56 下午
 * @since
 */
public class EhCacheTest {

    public static void main(String[] args) {
        URL ehcacheConfig = EhCacheTest.class.getClassLoader().getResource("ehcache.xml");
        Configuration config = new XmlConfiguration(ehcacheConfig);
        CacheManager cacheManager = CacheManagerBuilder.newCacheManager(config);
        cacheManager.init();

        Cache<String, String> hCache = cacheManager.getCache("first", String.class, String.class);
        hCache.put("add", "cc");
        System.out.println(hCache.get("add"));

        cacheManager.close();
    }
}
