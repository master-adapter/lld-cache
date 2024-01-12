package org.masterAdapter.storage;

import org.masterAdapter.exception.NotFoundException;

public interface CacheStorage<Key, Value> {

    public void addStorage(Key key, Value value);
    public void remove(Key key) throws NotFoundException;
    public Value getStorage(Key key) throws NotFoundException;
}
