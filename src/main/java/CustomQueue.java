import java.util.Stack;

public class CustomQueue<T> {

    private Stack<T> inputStack;
    private Stack<T> outputStack;


    public CustomQueue() {
        this.inputStack = new Stack<>();
        this.outputStack = new Stack<>();
    }

    //offer
    public T offer(T value){
        return inputStack.push(value);
    }

    //poll
    public T poll(){
        moveStack();
        return outputStack.pop();
    }

    public T peek(){
        moveStack();
        return outputStack.peek();
    }

    public int size(){
        return inputStack.size() + outputStack.size();
    }

    public boolean isEmpty(){
        if(inputStack.size() == 0 && outputStack.size() == 0) {
            return true;
        }
        return false;
    }

    private void moveStack(){
        if(outputStack.isEmpty()) {
            while(inputStack.size() > 0){
                outputStack.push(inputStack.pop());
            }
        }
    }



    @Override
    public String toString() {
        return inputStack.toString();
    }
}
