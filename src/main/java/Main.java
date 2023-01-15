import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static Stack<String> stackInput = new Stack<>();
    static Stack<String> stackOuput = new Stack<>();

    public static void main(String[] args) {
        Queue<String> cq = new LinkedList<>();
        cq.offer("test1");
        cq.offer("test2");
        cq.offer("test3");
        cq.offer("test4");
        cq.offer("test5");
        cq.offer("test6");

        System.out.println(cq.toString());

        int size = cq.size();

        for(int i=0; i<size; i++){
            System.out.println(cq.peek());
        }


        System.out.println(cq.poll());

        System.out.println(cq.toString());


    }


}