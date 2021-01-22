package w10.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThread2 {

    public void execute(int threadCount) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        for(int i=0; i<threadCount; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        try {

                        } catch(Exception e) {
                            System.out.println("\tException - " + Thread.currentThread().getName() + ": " + e.getMessage());
                        }
                    }
                }
            });
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        int threadCount = 2;
        MultiThread2 multiThread2 = new MultiThread2();
        multiThread2.execute(threadCount);
    }

}
