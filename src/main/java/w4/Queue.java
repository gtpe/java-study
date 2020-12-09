package w4;

public class Queue {

    int[] queue;
    int size;
    int head;
    int tail;

    public Queue(int size) {
        queue = new int[size];
        this.size = size;
    }

    public void enqueue(int value) {
        if(isFull())
            grow();
        queue[tail] = value;
        tail++;
    }

    public int dequeue() {
        int result = queue[head];
        head++;
        if(head >= (size / 2))
            optimize();
        return result;
    }

    private boolean isFull() {
        return (tail == size) ? true : false;
    }

    private void grow() {
        size *= 2;
        copyArray(size);
    }

    private void optimize() {
        if((tail - head) < (size / 2))
            size /= 2;
        copyArray(size);
    }

    private void copyArray(int size) {
        int[] temp = queue;
        queue = new int[size];
        for(int i=0; i<(tail-head); i++) {
            queue[i] = temp[i+head];
        }
        tail -= head;
        head = 0;
    }

}
