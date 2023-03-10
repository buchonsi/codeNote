import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class SemaphoreQueue<T> {

    private Semaphore semaphore;
    private Queue<T> queue;

    public SemaphoreQueue(Semaphore semaphore) {
        this.semaphore = semaphore;
        this.queue = new LinkedList<>();
    }

    public boolean offer(T value){
        boolean result;
        try {
            semaphore.acquire();
            result = queue.offer(value);
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    //poll
    public T poll(){
        synchronized (queue){
            return queue.poll();
        }
    }

    public T peek(){
        return queue.peek();
    }

    public int size(){
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return queue.toString();
    }

}
