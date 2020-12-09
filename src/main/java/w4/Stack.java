package w4;

public class Stack {

    int[] stack;
    int size;
    int top;

    public Stack(int size) {
        top = -1;
        stack = new int[size];
        this.size = size;
    }

    public int peek() {
        return stack[top];
    }

    public int pop() {
        int result = stack[top];
        stack[top] = 0;
        top--;
        return result;
    }

    public void push(int value) {
        stack[++top] = value;
    }

}
