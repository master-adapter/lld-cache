package org.masterAdapter.factory;

import org.masterAdapter.cache.Cache;
import org.masterAdapter.eviction.LRUEvictionPolicy;
import org.masterAdapter.storage.HashMapStorage;

public class CacheFactory<Key, Value>{

    public Cache<Key, Value> getDefaultCache(final int capacity){
    return new Cache<>(new HashMapStorage<>(capacity), new LRUEvictionPolicy<>());
    }
}
