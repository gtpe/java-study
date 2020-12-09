package w4;

import java.util.NoSuchElementException;

public class ListNodeQueue {

    ListNode head;

    public void enqueue(int value) {
        if(head == null) {
            head = new ListNode(value);
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }

    public int dequeue() {
        if(head == null)
            throw new NoSuchElementException();
        int value = head.value;
        head = head.remove(head, 0);
        return value;
    }

}
