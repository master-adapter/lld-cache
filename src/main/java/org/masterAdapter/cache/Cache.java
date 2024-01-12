package org.masterAdapter.cache;

import org.masterAdapter.eviction.EvictionPolicy;
import org.masterAdapter.exception.NotFoundException;
import org.masterAdapter.exception.StorageFullException;
import org.masterAdapter.storage.CacheStorage;

public class Cache<Key, Value> {
    final CacheStorage<Key, Value> storage;
    final EvictionPolicy<Key> evictionPolicy;

    public Cache(CacheStorage<Key, Value> storage, EvictionPolicy<Key> evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public void put(Key key, Value value){
        try {
            evictionPolicy.keyAccessed(key);
            storage.addStorage(key,value);
        } catch (StorageFullException storageFullException){
            Key evictionKey = evictionPolicy.evictKey();
            if(evictionKey == null) throw new RuntimeException("Something went wrong");
            storage.remove(evictionKey);
            put(key, value);
        }
    }

    public Value  get(Key key){
        try {
            Value value = storage.getStorage(key);
            evictionPolicy.keyAccessed(key);
            return value;
        } catch (NotFoundException notFoundException){
            System.out.println("Tried to access non-existing key");
            return null;
        }
    }
}
