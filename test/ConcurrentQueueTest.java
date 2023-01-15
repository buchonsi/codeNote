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
            for(int i=0; i<1000; i++){
                cq.offer("test" + i);
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i=1000; i<2000; i++){
                cq.offer("test" + i);
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

        //then
        assertThat(cq.size()).isEqualTo(2000);
    }

    @Test
    void poll() {
        //given
        ConcurrentQueue<String> cq = new ConcurrentQueue<>();
        for(int i=0; i<2000; i++) {
            cq.offer("test"+ i);
        }

        //when
        Thread t1 = new Thread(() -> {
            for(int i=0; i<1000; i++){
                cq.poll();
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i=1000; i<2000; i++){
                cq.poll();
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

        assertThat(cq.size()).isEqualTo(0);
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