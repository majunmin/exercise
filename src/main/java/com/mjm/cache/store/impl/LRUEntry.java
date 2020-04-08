package com.mjm.cache.store.impl;

import com.mjm.cache.store.ValueHolder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map.Entry;


public class LRUEntry<K, V extends ValueHolder<?>> implements Entry<K, ValueHolder<?>> {

	final K key; // non-null
	ValueHolder<?> v; // non-null

	@Getter
	@Setter
	LRUEntry<K, ValueHolder<?>> pre;
	@Getter
	@Setter
	LRUEntry<K, ValueHolder<?>> next;


	public LRUEntry(K key, V value) {
		super();

		this.key = key;
		this.v = value;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public ValueHolder<?> getValue() {
		return this.v;
	}

	@Override
	public ValueHolder<?> setValue(ValueHolder<?> value) {
		ValueHolder<?> oldValue = this.v;
		this.v = value;
		return oldValue;
	}

}