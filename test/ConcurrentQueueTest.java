import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ConcurrentQueueTest {

    @Test
    void offer() {
        //given
        ConcurrentQueue<String> cq = new ConcurrentQueue<>();

        //when
        Thread t1 = new Thread(() -> {
            System.out.println("thread1");

            for(int i=0; i<1000; i++){
                cq.offer("test" + i);
            }
        });
        Thread t2 = new Thread(() -> {
            System.out.println("thread2");
            for(int i=1000; i<2000; i++){
                cq.offer("test" + i);
            }
        });

        t1.start();
        t2.start();

        try {
            Thread.sleep(3000);
            t1.interrupt();
            t2.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //then
        System.out.println(cq.toString());
    }

    @Test
    void poll() {
    }

    @Test
    void peek() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }
}