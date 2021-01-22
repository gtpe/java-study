package w10.lock.reentrantLock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 테스트.
 * https://www.crocus.co.kr/1558
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        /**
         * ReentrantLock을 사용하지 않는 기존의 synchronized 사용 방법.
         * 스레드 10개를 순서에 맞게 실행시켜서 스레드 번호를 출력한다.
         *
         * CountDownLatch 에 대해서는 아래 URL 참조.
         * 다른 스레드가 특정 지점을 따라 잡을 때까지 기다리게 하는 기준선 역할.
         * https://www.crocus.co.kr/1557
         */
        /*
        AtomicInteger ordinal = new AtomicInteger(0);
        final CountDownLatch latch = new CountDownLatch(10);

        for(int i=0; i<10; ++i) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    synchronized (ordinal) {
                        ordinal.getAndIncrement();
                        System.out.println("Waiting " + ordinal.get() + " tread");
                        latch.countDown();
                    }
                    try {
                        latch.await();
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        }*/

        /**
         * ReentrantLock 사용 방법.
         * 스레드 20개가 ordinal 변수를 각각 1,000,000번씩 increment 시킨다.
         * 때문에 결과값은 20,000,000 로 출력된다.
         */
        ReentrantLock reentrantLock = new ReentrantLock();
        AtomicInteger ordinal = new AtomicInteger(0);

        /**
         * 기존 스레드를 동기화 하기 위해 사용하던 3개의 주요 메소드: wait(), notify(), notifyAll()은
         * ReentrantLock에서는 await(), signal(), signalAll() 메소드와 같다.
         * 하지만 이때는 Condition 객체를 이용하여 락을 관리한다.
         * (모든 것이 뮤텍스와 동일함을 알 수 있다.)
         */
        Condition condition = reentrantLock.newCondition();

        for(int i=0; i<20; i++) {
            reentrantLock.lock(); // 스레드에 락을 건다. (동기화의 시작.)
            Thread thread = new Thread() {
                @Override
                public void run() {
                    for(int i=0; i<1000000; i++) {
                        ordinal.getAndIncrement();
                    }
                    // ... 동기화 내용들 ...
                    /*try {
                        condition.await(); // 기존의 동기화에서 wait();
                        condition.signal(); // 기존의 동기화에서 notify();
                        condition.signalAll(); // 기존의 동기화에서 notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                }
            };
            thread.start();
            reentrantLock.unlock(); // 스레드 락을 푼다. (동기화 끝지점.)
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(ordinal.get());

    }
}
