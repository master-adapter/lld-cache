package org.masterAdapter.storage;

import org.masterAdapter.exception.NotFoundException;
import org.masterAdapter.exception.StorageFullException;

import java.util.HashMap;

public class HashMapStorage<Key, Value> implements CacheStorage<Key, Value>{
    private final Integer capacity;
    HashMap<Key, Value> storage;

    public HashMapStorage(Integer capacity) {
        this.capacity = capacity;
        storage = new HashMap<>();
    }

    @Override
    public void addStorage(Key key, Value value) {
        if(storage.size() >= capacity) throw new StorageFullException();
        storage.put(key,value);

    }

    @Override
    public void remove(Key key) throws NotFoundException {
        if(!storage.containsKey(key)) throw  new NotFoundException(key + "Not found in cache");
        storage.remove(key);

    }

    @Override
    public Value getStorage(Key key) throws NotFoundException {
        if(!storage.containsKey(key)) throw  new NotFoundException(key + "Not found in cache");
        return storage.get(key);
    }
}
