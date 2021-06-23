package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class 按序打印 {
}

//class Foo {
//
//    private AtomicInteger firstJobDone;
//    private AtomicInteger secondJobDone;
//
//    public Foo() {
//        firstJobDone = new AtomicInteger(0);
//        secondJobDone = new AtomicInteger(0);
//    }
//
//    public void first(Runnable printFirst) throws InterruptedException {
//
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        firstJobDone.incrementAndGet();
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//
//        while (firstJobDone.get()!=1){
//
//        }
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//        secondJobDone.incrementAndGet();
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        while (secondJobDone.get()!=1){
//
//        }
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
//    }
//}


//class Foo {
//
//    private boolean firstJobDone;
//    private boolean secondJobDone;
//    private Object lock = new Object();
//
//    public Foo() {
//    }
//
//    public void first(Runnable printFirst) throws InterruptedException {
//        synchronized (lock){
//            printFirst.run();
//            firstJobDone=true;
//            lock.notifyAll();
//        }
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//
//        synchronized (lock){
//            while (!firstJobDone){
//                lock.wait();
//            }
//            printSecond.run();
//            secondJobDone = true;
//            lock.notifyAll();
//        }
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        synchronized (lock){
//            while (!secondJobDone){
//                lock.wait();
//            }
//            printThird.run();
//        }
//    }
//}

class Foo {
    Semaphore spa;
    Semaphore spb;

    public Foo() {
        spa = new Semaphore(0);
        spb = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        printFirst.run();
        spa.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        spa.acquire();
        printSecond.run();
        spb.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        spb.acquire();
        printThird.run();
    }
}


