package thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;

public class 交替打印FooBar {
}

//自旋+yield
class FooBar {
    volatile boolean printFooFlag = true;

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0;i<n;){
            if (printFooFlag){
                printFoo.run();
                printFooFlag=false;
                i++;
            } else {
                Thread.yield();
            }
        }


    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0;i<n;){
            if (!printFooFlag){
                printBar.run();
                printFooFlag=true;
                i++;
            } else {
                Thread.yield();
            }
        }
    }
}

////blocking queue
//class FooBar {
//    BlockingQueue<Integer> foo = new LinkedBlockingDeque(1);
//    BlockingQueue<Integer> bar = new LinkedBlockingDeque(1);
//
//    private int n;
//
//    public FooBar(int n) {
//        this.n = n;
//    }
//
//    public void foo(Runnable printFoo) throws InterruptedException {
//        for (int i = 0; i < n; i++) {
//            foo.put(0);
//            printFoo.run();
//            bar.put(0);
//        }
//    }
//
//    public void bar(Runnable printBar) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//            bar.take();
//            printBar.run();
//            foo.take();
//        }
//    }
//}

//Semaphore
//class FooBar {
//    private int n;
//
//    public FooBar(int n) {
//        this.n = n;
//    }
//
//    Semaphore semaphoreA = new Semaphore(1);
//    Semaphore semaphoreB = new Semaphore(0);
//
//    public void foo(Runnable printFoo) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//            semaphoreA.acquire();
//            // printFoo.run() outputs "foo". Do not change or remove this line.
//            printFoo.run();
//            semaphoreB.release();
//        }
//    }
//
//    public void bar(Runnable printBar) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//            semaphoreB.acquire();
//            // printBar.run() outputs "bar". Do not change or remove this line.
//            printBar.run();
//            semaphoreA.release();
//        }
//    }
//}