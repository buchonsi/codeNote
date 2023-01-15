import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS) --seach
class CustomQueueTest {

    CustomQueue<Integer> queue;

    @BeforeEach
    void initQueue(){
        queue = new CustomQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
    }


    @Test
    @DisplayName("offer 동작 확인")
    void offer() {
        //given
        int testData = 4;

        //when
        int result = queue.offer(testData);

        //then
        assertThat(result).isEqualTo(testData);
    }

    @Test
    @DisplayName("poll 동작 확인")
    void poll() {
        //given
        //when
        int result = queue.poll();

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("peek 동작 확인")
    void peek() {
        //given
        //when
        int result = queue.peek();

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("queue size 확인")
    void size() {
        //given
        //when
        int result = queue.size();

        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("queue empty 확인")
    void isEmpty() {
        //given
        CustomQueue<Integer> emptyQueue = new CustomQueue<>();

        //when
        boolean result = emptyQueue.isEmpty();

        //then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("큐에 값을 하나 빼고 데이터 확인")
    void after_poll_view_queue() {
        //given
        List<Integer> list = new ArrayList<>();

        //when
        int result = queue.poll();

        int len = queue.size();
        for(int i=0; i<len; i++){
            list.add(queue.poll());
        }

        //then
        assertThat(list).containsExactly(2,3);
    }

    @Test
    @DisplayName("큐에서 값을 하나 확인하고 데이터 확인")
    void after_peek_view_queue() {
        //given
        List<Integer> list = new ArrayList<>();
        int len = queue.size();

        //when
        int result = queue.peek();

        for(int i=0; i<len; i++){
            list.add(queue.poll());
        }

        //then
        assertThat(list).containsExactly(1,2,3);
    }
}