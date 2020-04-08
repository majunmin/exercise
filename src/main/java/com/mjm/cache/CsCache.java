package com.mjm.cache;

import com.mjm.cache.store.DataStore;
import com.mjm.cache.store.StoreAccessException;
import com.mjm.cache.store.ValueHolder;
import lombok.extern.slf4j.Slf4j;

/**
 * 直接使用 CSCache 的 接口类
 */
@Slf4j
public class CsCache<K, V> {
	private final DataStore<K, V> store;

	// 参数是 传入数据存储  和淘汰策略对象
	public CsCache(final DataStore<K, V> dataStore) {
		store = dataStore;
	}

	public V get(final K key) {
		try {
			// 从数据存储和淘汰策略对象 获取缓存数据
			ValueHolder<V> value = store.get(key);
			if (null == value) {
				return null;
			}
			// 返回缓存数据
			return value.value();
		} catch (StoreAccessException e) {
			log.error("store access error : ", e.getMessage());
			log.error(e.getStackTrace().toString());
			return null;
		}
	}

	public void put(final K key, final V value) {
		try {

			store.put(key, value);
		} catch (StoreAccessException e) {
			log.error("store access error : ", e.getMessage());
			log.error(e.getStackTrace().toString());
		}
	}

	public V remove(K key) {
		try {
			ValueHolder<V> value = store.remove(key);
			return value.value();
		} catch (StoreAccessException e) {
			log.error("store access error : ", e.getMessage());
			log.error(e.getStackTrace().toString());
			return null;
		}
	}

	public void clear() {
		try {
			store.clear();
		} catch (StoreAccessException e) {
			log.error("store access error : ", e.getMessage());
			log.error(e.getStackTrace().toString());
		}
	}
}
