package w10.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * 세마포어 테스트.
 */

/**
 * 총 20개의 스레드를 동시다발적으로 호출할 때,
 * 세마포어에는 4개의 허용값을 할당하는 식으로 동작한다.
 */
public class SemaphoreTest {
    private static final Random random = new Random(10000);

    static class Log {
        public static void debug(String message) {
            System.out.println(Thread.currentThread().getName() + ": " + message);
        }
    }

    class SemaphoreResource extends Semaphore {
        public SemaphoreResource(final int permits) {
            super(permits);
        }

        public void use() throws InterruptedException {
            acquire(); // 세마포어 리소스 확보.
            try {
                doUse();
            } finally {
                release(); // 세마포어 리소스 해제.
                Log.debug("Thread 종료 후 남은 permits: " + this.availablePermits());
            }
        }

        private void doUse() throws InterruptedException {
            // 임의의 프로그램을 실행하는데 걸리는 가상의 시간.
            int sleepTime = random.nextInt(500);
            Thread.sleep(sleepTime); // 런타임 시간 설정.
            Log.debug("Thread 실행: " + sleepTime);
            // ... something logic ...
        }
    }

    class MyThread extends Thread {
        private final SemaphoreResource resource;

        public MyThread(String threadName, SemaphoreResource resource) {
            this.setName(threadName);
            this.resource = resource;
        }

        @Override
        public void run() {
            try {
                resource.use();
            } catch(InterruptedException e) {
            } finally {
            }
        }
    }

    /**
     * 총 20개의 스레드를 동시다발적으로 호출할 때,
     * 세마포어에는 4개의 허용값을 할당하는 식으로 동작한다.
     */
    public static void main(String[] args) {
        SemaphoreResource resource = new SemaphoreTest().new SemaphoreResource(4);
        for(int i=0; i<20; i++) {
            new SemaphoreTest().new MyThread("Thread-" + i, resource).start();
        }
    }

}
