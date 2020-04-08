package com.mjm.cache.store.impl;

import java.lang.ref.WeakReference;

import com.mjm.cache.store.ValueHolder;

public class WeakValueHolder<V> implements ValueHolder<V> {

	/**
	 * 使用 JDk提供的 WeakReferecce。， 建立对象的引用
	 * 在没有强引用的时候 JVM GC回收对象，调用WeakReference.get(key) 返回 null
	 *
	 * @param value
	 */
	public WeakValueHolder(V value) {
		super();
		if (null == value) {
			return;
		}
		this.v = new WeakReference<V>(value);
	}

	private WeakReference<V> v;

	@Override
	public V value() {
		return this.v.get();
	}

}