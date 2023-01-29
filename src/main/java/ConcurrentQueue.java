import com.sun.source.tree.SynchronizedTree;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class ConcurrentQueue<T>{

    Queue<T> queue;

    public ConcurrentQueue() {
        queue = new LinkedList<>();
    }

    //offer
    public boolean offer(T value){
//        synchronized (queue){
            return queue.offer(value);
//        }
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
