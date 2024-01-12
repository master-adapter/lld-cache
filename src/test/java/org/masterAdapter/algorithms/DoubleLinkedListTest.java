package org.masterAdapter.algorithms;

import junit.framework.TestCase;
import org.junit.Test;
import com.google.common.collect.ImmutableList;

import java.util.List;

public class DoubleLinkedListTest extends TestCase {
    @Test
    public void testDLLAddition() {
        DoubleLinkedListNode<Integer> node1 = new DoubleLinkedListNode<>(1);
        DoubleLinkedListNode<Integer> node2 = new DoubleLinkedListNode<>(2);
        DoubleLinkedListNode<Integer> node3 = new DoubleLinkedListNode<>(3);
        DoubleLinkedListNode<Integer> node4 = new DoubleLinkedListNode<>(4);

        DoubleLinkedList dll = new DoubleLinkedList<>();

        dll.addNodeAtLast(node1);
        verifyDLL(dll, ImmutableList.of(1));

        dll.addNodeAtLast(node2);
        verifyDLL(dll, ImmutableList.of(1, 2));

        dll.addNodeAtLast(node3);
        verifyDLL(dll, ImmutableList.of(1, 2, 3));

        dll.addNodeAtLast(node4);
        verifyDLL(dll, ImmutableList.of(1, 2, 3, 4));

        dll.addElementAtLast(5);
        verifyDLL(dll, ImmutableList.of(1, 2, 3, 4, 5));
    }

    @Test
    public void testDLLNodeDetachment() {
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();

        DoubleLinkedListNode<Integer> node1 = dll.addElementAtLast(1);
        DoubleLinkedListNode<Integer> node2 = dll.addElementAtLast(2);
        DoubleLinkedListNode<Integer> node3 = dll.addElementAtLast(3);
        DoubleLinkedListNode<Integer> node4 = dll.addElementAtLast(4);
        DoubleLinkedListNode<Integer> node5 = dll.addElementAtLast(5);

        verifyDLL(dll, ImmutableList.of(1, 2, 3, 4, 5));

        dll.detachNode(node1);
        verifyDLL(dll, ImmutableList.of(2, 3, 4, 5));

        dll.detachNode(node5);
        verifyDLL(dll, ImmutableList.of(2, 3, 4));

        dll.detachNode(node3);
        verifyDLL(dll, ImmutableList.of(2, 4));

        dll.detachNode(null);
        verifyDLL(dll, ImmutableList.of(2, 4));
    }

    public void verifyDLL(DoubleLinkedList<Integer> dll, List<Integer> expectedListElements) {
        assertEquals(expectedListElements.get(expectedListElements.size() - 1), dll.getLastNode().getValue());
        assertEquals(expectedListElements.get(0), dll.getFirstNode().getValue());

        DoubleLinkedListNode<Integer> currentNode = dll.getFirstNode();
        for (Integer expectedListElement : expectedListElements) {
            assertNotNull(currentNode);
            assertEquals(expectedListElement, currentNode.getValue());
            currentNode = currentNode.getRight();
        }
        assertNull(currentNode.right);
    }
}