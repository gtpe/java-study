package w4;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeQueueTest {

    @Test
    void enDeListNodeQueque() {
        ListNodeQueue listNodeQueue = new ListNodeQueue();
        assertThrows(NoSuchElementException.class , () -> {
            listNodeQueue.dequeue();
        });
        listNodeQueue.enqueue(9);
        listNodeQueue.enqueue(5);
        listNodeQueue.enqueue(7);
        assertEquals(9, listNodeQueue.dequeue());
        assertEquals(5, listNodeQueue.dequeue());
        assertEquals(7, listNodeQueue.dequeue());
    }

}