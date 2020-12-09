package w4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void pushPop() {
        Stack stack = new Stack(5);
        stack.push(2);
        stack.push(1);
        stack.push(5);
        assertEquals(2, stack.top);
        assertEquals(5, stack.pop());
        assertEquals(1, stack.pop());
        assertEquals(0, stack.top);
        assertEquals(2, stack.pop());
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            stack.pop();
        });
    }

}