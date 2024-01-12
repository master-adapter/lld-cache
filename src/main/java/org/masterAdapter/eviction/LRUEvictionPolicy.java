package org.masterAdapter.eviction;


import org.masterAdapter.algorithms.DoubleLinkedList;
import org.masterAdapter.algorithms.DoubleLinkedListNode;
import org.masterAdapter.storage.HashMapStorage;

import java.util.HashMap;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    DoubleLinkedList<Key> dll;
    HashMap<Key, DoubleLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy() {
        this.dll = new DoubleLinkedList<>();
        this.mapper =new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if(mapper.containsKey(key)){
            dll.detachNode(mapper.get(key));
            dll.addNodeAtLast(mapper.get(key));
        }else {
            DoubleLinkedListNode<Key> newNode = dll.addElementAtLast(key);
            mapper.put(key, newNode);
        }

    }

    @Override
    public Key evictKey() {
        DoubleLinkedListNode<Key> first = dll.getFirstNode();
        if(first == null)return null;
        dll.detachNode(first);
        return first.getValue();
    }
}
