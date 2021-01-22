package w10.thread;

/**
 *
 * wait(), notify(), notifyAll()은 synchronized 내부(lock을 소유한) 스레드가 수행한다.
 * wait()는 스레드를 WAIT SET으로 대기하게 한다.
 *  갖고 있던 고유 락을 해제하고, 스레드를 잠들게 한다.
 *  호출하는 스레드가 반드시 고유 락을 갖고 있어야 한다.
 *  다시 말해, synchronized 블록 내에서 호출되어야 한다.
 * notify(), notifyAll()은 WAIT SET에서 대기중인 스레드를 깨운다.
 * notify(): 잠들어 있던 스레드 중 임의로 하나를 골라 깨운다.
 * notifyAll(): 잠들어 있던 스레드 모두 깨운다.
 *
 */
public class ATM implements Runnable {
    private long deposit = 10000;

    public void run() {
        synchronized (this) {
            for(int i=0; i<10; i++) {
                notify(); // 일시정지 상태인 다른 스레드를 깨움.
                System.out.println("# i: " + i + " / " + Thread.currentThread().getName());

                try {
                    wait(); // 다른 스레드에게 제어권을 넘겨줌.
                    System.out.println("# i: " + i + " / " + Thread.currentThread().getName());
                    Thread.sleep(1000);
                } catch(InterruptedException ie) {
                    ie.printStackTrace();
                }

                if(getDeposit() <= 0) {
                    break;
                }
                withDraw(1000);
            }
        }
    }

    public void withDraw(long howMuch) {
        if(getDeposit() > 0) {
            deposit -= howMuch;
            System.out.print(Thread.currentThread().getName() + " , ");
            System.out.printf("잔액 : %,d 원 %n", getDeposit());
        } else {
            System.out.print(Thread.currentThread().getName() + " , ");
            System.out.printf("잔액이 부족합니다.");
        }
    }

    public long getDeposit() {
        return deposit;
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        Thread mother = new Thread(atm, "mother");
        Thread son = new Thread(atm, "son");
        mother.start();
        son.start();
    }
}
