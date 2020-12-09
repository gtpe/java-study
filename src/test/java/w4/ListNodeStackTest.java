package w4;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeStackTest {

    @Test
    void pushPopListNodeStack() {
        ListNodeStack listNodeStack = new ListNodeStack();
        assertThrows(EmptyStackException.class, () -> {
            listNodeStack.pop();
        });
        listNodeStack.push(5);
        listNodeStack.push(1);
        listNodeStack.push(2);
        assertEquals(2, listNodeStack.pop());
        assertEquals(1, listNodeStack.pop());
        assertEquals(5, listNodeStack.pop());
    }

}