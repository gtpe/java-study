package w10.thread;

public class MultiThread implements Runnable {

    int testNum = 0;

    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            if(Thread.currentThread().getName().equals("A")) {
                System.out.println("=============================");
                testNum++;
            }
            System.out.println("# theadName: " + Thread.currentThread().getName() + " / testNum: " + testNum);

            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MultiThread mt1 = new MultiThread();
        MultiThread mt2 = new MultiThread();
        Thread thread1 = new Thread(mt1, "A");
        Thread thread2 = new Thread(mt2, "B");
        thread1.start();
        thread2.start();
    }

}
