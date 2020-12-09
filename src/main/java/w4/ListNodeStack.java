package w4;

import java.util.EmptyStackException;

public class ListNodeStack {

    ListNode head;

    public int pop() {
        if(head == null)
            throw new EmptyStackException();
        int value = head.value;
        ListNode removed = head.remove(head, 0);
        head = removed;
        return value;
    }

    public void push(int value) {
        if(head == null) {
            head = new ListNode(value);
        } else {
            ListNode nodeToPush = new ListNode(value);
            head = head.add(head, nodeToPush, 0);
        }
    }

}
