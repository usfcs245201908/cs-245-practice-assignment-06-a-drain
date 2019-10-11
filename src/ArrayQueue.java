import java.sql.Array;
import java.util.Arrays;

public class ArrayQueue<T> implements Queue {

    private Object[] a;
    private int front;
    private int back;

    ArrayQueue(){
        a = new Object[10];
        this.front = 0;
        this.back = 0;
    }

    private void growArray(){
        Object[] copy = Arrays.copyOfRange(a, 0, a.length*2);
        a = copy;
    }

    public boolean empty(){
        return front == back;
    }

    public Object dequeue() throws Exception{
        if(empty()){
            throw new Exception("Empty queue");
        }
        return a[front++];
    }

    public void enqueue(Object item){
        if(back == a.length){
            growArray();
        }
        a[back++] = item;
    }

    public static void main(String[] args) throws Exception {
        ArrayQueue queue = new ArrayQueue();
        String first = "First";
        String second = "Second";
        queue.enqueue(first);
        queue.enqueue(second);

        if (queue.dequeue() == first && queue.dequeue() == second && queue.empty()) {
            System.out.println("[+10%] Queue functions appear correct.");
        }

    }
}
