package org.masterAdapter.algorithms;

import org.masterAdapter.exception.InvalidElementException;

public class DoubleLinkedList<E> {

    DoubleLinkedListNode<E> head;
    DoubleLinkedListNode<E> tail;

    public DoubleLinkedList(){
        head = new DoubleLinkedListNode<E>(null);
        tail = new DoubleLinkedListNode<E>(null);

        head.right = tail;
        tail.left = head;
    }

    public void detachNode(DoubleLinkedListNode<E> node){
        if(node!= null){
            node.left.right = node.right;
            node.right.left = node.left;
        }
    }

    public  void addNodeAtLast(DoubleLinkedListNode<E> node){
        if(node == null)return;

        DoubleLinkedListNode<E> tempNode = tail.left;
        tempNode.right = node;
        node.right =  tail;
        tail.left = node;
        node.left = tempNode;

    }

    public DoubleLinkedListNode<E>  addElementAtLast(E element){
        if(element == null){
            throw new InvalidElementException();
        }
        DoubleLinkedListNode<E> newNode = new DoubleLinkedListNode<>(element);
        addNodeAtLast(newNode);
        return newNode;
    }

    public boolean isItemPresent(){
        return head.right != tail;
    }

    public DoubleLinkedListNode<E> getFirstNode(){
        DoubleLinkedListNode item = null;
        if(!isItemPresent()){
            return null;
        }
        return head.right;
    }

    public DoubleLinkedListNode<E> getLastNode(){
        DoubleLinkedListNode item = null;
        if(!isItemPresent()){
            return null;
        }
        return tail.left;
    }
}
