import com.sun.source.tree.SynchronizedTree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class ConcurrentQueue<T> {

    Queue<T> queue;

    public ConcurrentQueue() {
        queue = new LinkedList<>();
    }

    //offer
    public synchronized boolean offer(T value){
         return queue.offer(value);
    }

    //poll
    public T poll(){
        return queue.poll();
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
