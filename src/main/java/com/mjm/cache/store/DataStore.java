package com.mjm.cache.store;

/**
 * 存储数据规范定义 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-02-19 17:06
 * @since
 */
public interface DataStore<K, V> {
    ValueHolder<V> get(K key) throws StoreAccessException;

    PutStatus put(K key, V value) throws StoreAccessException;

    ValueHolder<V> remove(K key) throws StoreAccessException;

    void clear() throws StoreAccessException;

    enum PutStatus {
        /**
         * New value was put
         */
        PUT,
        /**
         * New value was put and replace old value
         */
        UPDATE,
        /**
         * New value was dropped
         */
        NOOP
    }
}
