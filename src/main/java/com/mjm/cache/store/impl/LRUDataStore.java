package com.mjm.cache.store.impl;

import java.util.concurrent.ConcurrentHashMap;

import com.mjm.cache.store.DataStore;
import com.mjm.cache.store.StoreAccessException;
import com.mjm.cache.store.ValueHolder;

public class LRUDataStore<K, V> implements DataStore<K, V> {

	public LRUDataStore(int maxSize) {
		super();
		this.maxSize = maxSize;
	}

	private final int maxSize;

	ConcurrentHashMap<K, LRUEntry<K, ValueHolder<?>>> map = new ConcurrentHashMap<K, LRUEntry<K, ValueHolder<?>>>();

	private LRUEntry<K, ValueHolder<?>> first;
	private LRUEntry<K, ValueHolder<?>> last;

	@SuppressWarnings("unchecked")
	@Override
	public ValueHolder<V> get(K key) throws StoreAccessException {
		LRUEntry<K, ValueHolder<?>> entry = (LRUEntry<K, ValueHolder<?>>) getEntry(key);
		if (entry == null) {
			return null;
		}
		// 在获取数据的时候 将 entry 节点移动到列表头
		moveToFirst(entry);
		return (ValueHolder<V>) entry.getValue();

	}

	@Override
	public PutStatus put(K key, V value) throws StoreAccessException {
		LRUEntry<K, ValueHolder<?>> entry = (LRUEntry<K, ValueHolder<?>>) getEntry(key);
		PutStatus status = PutStatus.NOOP;
		if (entry == null) {
			/**
			 * 数据缓存列表中的数据 已经超过预定值，删除列表尾 的节点数据， 以实现 LRU 算法
			 */
			if (map.size() >= maxSize) {
				map.remove(last.getKey());
				removeLast();
			}
			entry = new LRUEntry<K, ValueHolder<?>>(key, new BasicValueHolder<V>(value));
			status = PutStatus.PUT;
		} else {
			entry.setValue(new BasicValueHolder<V>(value));
			status = PutStatus.UPDATE;
		}
		/**
		 * xintianjaideshuju fangdaoliebiao toubu
		 */
		moveToFirst(entry);
		map.put(key, entry);
		return status;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ValueHolder<V> remove(K key) throws StoreAccessException {
		LRUEntry<K, ValueHolder<?>> entry = getEntry(key);
		if (entry != null) {
			if (entry.getPre() != null)
				entry.getPre().setNext(entry.getNext());
			if (entry.getNext() != null)
				entry.getNext().setPre(entry.getPre());
			if (entry == first)
				first = entry.getNext();
			if (entry == last)
				last = entry.getPre();
		}
		LRUEntry<K, ValueHolder<?>> oldValue = map.remove(key);
		return (ValueHolder<V>) oldValue.getValue();
	}

	@Override
	public void clear() throws StoreAccessException {
		this.map.clear();
		this.first = this.last = null;
	}

	private void moveToFirst(LRUEntry<K, ValueHolder<?>> entry) {
		if (entry == first)
			return;
		if (entry.getPre() != null)
			entry.getPre().setNext(entry.getNext());
		if (entry.getNext() != null)
			entry.getNext().setPre(entry.getPre());
		if (entry == last)
			last = last.getPre();

		if (first == null || last == null) {
			first = last = entry;
			return;
		}

		entry.setNext(first);
		first.setPre(entry);
		first = entry;
		entry.setPre(null);
	}

	private void removeLast() {
		if (last != null) {
			last = last.getPre();
			if (last == null)
				first = null;
			else
				last.next = null;
		}
	}

	private LRUEntry<K, ValueHolder<?>> getEntry(K key) {
		return map.get(key);
	}

}