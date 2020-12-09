package w4;

public class ListNode {

    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }

    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        ListNode current = head;
        if(position == 0) {
            nodeToAdd.next = current;
            return nodeToAdd;
        }
        for(int index=0; index<(position-1); index++) {
            current = current.next;
        }
        ListNode nodeToAddNext = current.next;
        nodeToAdd.next = nodeToAddNext;
        current.next = nodeToAdd;
        return head;
    }

    public ListNode remove(ListNode head, int positionToRemove) {
        ListNode current = head;
        if(positionToRemove == 0) {
            return head.next;
        }
        for(int index=0; index<(positionToRemove-1); index++) {
            current = current.next;
        }
        ListNode nodeToRemove = current.next;
        current.next = nodeToRemove.next;
        return head;
    }

    public boolean contains(ListNode head, ListNode nodeToCheck) {
        ListNode current = head;
        while(current != null) {
            if(current == nodeToCheck) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

}
