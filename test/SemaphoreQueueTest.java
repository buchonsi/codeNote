import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

import static org.junit.jupiter.api.Assertions.*;

class SemaphoreQueueTest {

    @Test
    void semaphoreTest(){
        Semaphore semaphore = new Semaphore(2);

        SemaphoreQueue semaphoreQueue = new SemaphoreQueue(semaphore);

        Thread t1 = new Thread(()->{
            for(int i=0; i<100; i++){
                semaphoreQueue.offer("test" + i);
            }
        });

        Thread t2 = new Thread(()->{
            for(int i=100; i<200; i++){
                semaphoreQueue.offer("test" + i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.out.println(semaphoreQueue.toString());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }

}