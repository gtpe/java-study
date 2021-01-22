package w10.thread;

/**
 * 싱글 스레드 예제
 * Runnable 구현하는 방법.
 * (Thread를 상속하는 방법보다 Runnable 구현 방법을 더 많이 사용. 다중상속이 안되기 때문에.)
 */
public class SingleThread2 implements Runnable {
    private int[] temp;

    public SingleThread2() {
        temp = new int[10];
        for(int i=0; i<temp.length; i++) {
            temp[i] = i;
        }
    }

    @Override
    public void run() {
        for(int i : temp) {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ie) {
                ie.printStackTrace();
            }
            System.out.println("# threadName: " + Thread.currentThread().getName());
            System.out.println("# temp: " + i);
        }
    }

    public static void main(String[] args) {
        SingleThread2 st = new SingleThread2();
        Thread t = new Thread(st, "첫번째");
        t.start();
    }

}
