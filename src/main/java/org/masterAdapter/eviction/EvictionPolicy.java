package org.masterAdapter.eviction;

public interface EvictionPolicy<Key> {

     void keyAccessed(Key key);
    Key evictKey();
}
