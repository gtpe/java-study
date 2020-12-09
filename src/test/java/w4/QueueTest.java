package w4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class QueueTest {

    @Test
    void enqueueDequeue() {
        Queue queue = new Queue(3);
        queue.enqueue(2);
        queue.enqueue(5);
        queue.enqueue(7);
        queue.enqueue(9);
        assertEquals(6, queue.size);
        assertEquals(2, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertEquals(7, queue.dequeue());
        assertEquals(0, queue.head);
        assertEquals(1, queue.tail);
        queue.enqueue(9);
        queue.enqueue(1);
        queue.enqueue(2 );
        assertEquals(6, queue.size);
        assertEquals(0, queue.head);
        assertEquals(4, queue.tail);
        queue.enqueue(6);
        queue.enqueue(8);
        queue.enqueue(3);
        assertEquals(12, queue.size);
        assertEquals(9, queue.dequeue());
        assertEquals(9, queue.dequeue());
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(6, queue.dequeue());
        assertEquals(8, queue.dequeue());
        assertEquals(0, queue.head);
        assertEquals(1, queue.tail);
        assertEquals(6, queue.size);
    }

}