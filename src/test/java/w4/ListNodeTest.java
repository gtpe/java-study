package w4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {

    ListNode head;

    @BeforeEach
    void addListNode() {
        head = new ListNode(2);
        head = head.add(head, new ListNode(5), 0);
        head = head.add(head, new ListNode(7), 2);
        assertEquals(5, head.value);
        assertEquals(2, head.next.value);
        assertEquals(7, head.next.next.value);
        head = head.add(head, new ListNode(9), 1);
        assertEquals(5, head.value);
        assertEquals(9, head.next.value);
        assertEquals(2, head.next.next.value);
        assertEquals(7, head.next.next.next.value);
    }

    @Test
    void removeListNode() {
        head = head.remove(head, 0);
        assertEquals(9, head.value);
        assertEquals(2, head.next.value);
        assertEquals(7, head.next.next.value);
        head = head.remove(head, 2);
        assertEquals(9, head.value);
        assertEquals(2, head.next.value);
    }

    @Test
    void containsListNode() {
        ListNode nodeToCheck_true = new ListNode(1);
        head = head.add(head, nodeToCheck_true, 1);
        assertTrue(head.contains(head, nodeToCheck_true));
        ListNode nodeToCheck_false = new ListNode(5);
        assertFalse(head.contains(head, nodeToCheck_false));
    }

}