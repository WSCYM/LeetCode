package thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class 打印零与奇偶数 {
}

class ZeroEvenOdd {

    //自旋+yield
    volatile private int n;
    volatile private boolean isPrint0;
    volatile private boolean isPrintOdd;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.isPrint0 = true;
        this.isPrintOdd = true;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

            for (int i=0;i<n;i++){
                while (!isPrint0){
                    Thread.yield();
                }
                printNumber.accept(0);
                isPrint0=false;
            }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2;i<=n;i+=2){
            while (isPrint0 || isPrintOdd){
                Thread.yield();
            }
            printNumber.accept(i);
            isPrintOdd = true;
            isPrint0 = true;
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i+=2){
            while (isPrint0 || !isPrintOdd){
                Thread.yield();
            }
            printNumber.accept(i);
            isPrintOdd = false;
            isPrint0 = true;
        }
    }

    //信号量
//    private int n;
//    private Semaphore semaphore0 = new Semaphore(1);
//    private Semaphore semaphoreOdd = new Semaphore(0);
//    private Semaphore semaphoreEven = new Semaphore(0);
//    private volatile boolean isPrintOdd = true;
//
//    public ZeroEvenOdd(int n) {
//        this.n = n;
//    }
//
//    // printNumber.accept(x) outputs "x", where x is an integer.
//    public void zero(IntConsumer printNumber) throws InterruptedException {
//        for (int i = 0;i<n;i++){
//            semaphore0.acquire();
//            printNumber.accept(0);
//            if (isPrintOdd) {
//                semaphoreOdd.release();
//            } else {
//                semaphoreEven.release();
//            }
//        }
//    }
//
//    public void even(IntConsumer printNumber) throws InterruptedException {
//        for (int i = 2; i<=n; i+=2){
//            semaphoreEven.acquire();
//            printNumber.accept(i);
//            isPrintOdd = true;
//            semaphore0.release();
//        }
//    }
//
//    public void odd(IntConsumer printNumber) throws InterruptedException {
//        for (int i = 1;i<=n;i+=2){
//            semaphoreOdd.acquire();
//            printNumber.accept(i);
//            isPrintOdd = false;
//            semaphore0.release();
//        }
//    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
