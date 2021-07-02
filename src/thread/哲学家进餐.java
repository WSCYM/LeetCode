package thread;

import java.util.concurrent.Semaphore;

public class 哲学家进餐 {
}

class DiningPhilosophers {
    Semaphore[] sps = new Semaphore[]{
      new Semaphore(1),
      new Semaphore(1),
      new Semaphore(1),
      new Semaphore(1),
      new Semaphore(1)
    };

    Semaphore spEatCnt = new Semaphore(4);

    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int leftNum = philosopher%5;
        int rightNum = (philosopher+1)%5;
        spEatCnt.acquire();

        sps[leftNum].acquire();
        sps[rightNum].acquire();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putRightFork.run();
        putLeftFork.run();
        sps[rightNum].release();
        sps[leftNum].release();

        spEatCnt.release();
    }
}