package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class H2O生成 {
}

class H2O {

    Semaphore spH = new Semaphore(2);
    Semaphore spO = new Semaphore(0);
    volatile static int cntH = 0;

    public H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        spH.acquire();
        cntH++;
        releaseHydrogen.run();
        if ((cntH&1)==0){
            spO.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        spO.acquire();
        releaseOxygen.run();
        spH.release();
        spH.release();
    }
}
