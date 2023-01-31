import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SemaphoreQueueTest {

    @Test
    @DisplayName("Semaphore를 이용한 offer")
    void offerTest(){
        //given
        Semaphore semaphore = new Semaphore(1);
        SemaphoreQueue semaphoreQueue = new SemaphoreQueue(semaphore);

        //when
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
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        assertThat(semaphoreQueue.size()).isEqualTo(200);
    }

    @Test
    @DisplayName("Semaphore를 이용한 poll")
    void pollTest(){
        //given
        Semaphore semaphore = new Semaphore(1);
        SemaphoreQueue semaphoreQueue = new SemaphoreQueue(semaphore);

        for(int i=0; i<200; i++){
            semaphoreQueue.offer("test" + i);
        }

        //when
        Thread t1 = new Thread(()->{
            for(int i=0; i<100; i++){
                semaphoreQueue.poll();
            }
        });

        Thread t2 = new Thread(()->{
            for(int i=100; i<200; i++){
                semaphoreQueue.poll();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        assertThat(semaphoreQueue.size()).isEqualTo(0);
    }


}