package org.masterAdapter.algorithms;

import lombok.Getter;

@Getter
public class DoubleLinkedListNode<E> {
    DoubleLinkedListNode<E> left;
    DoubleLinkedListNode<E> right;
    E value;

    public DoubleLinkedListNode( E value) {
        this.left =null;
        this.right = null;
        this.value = value;
    }
}
