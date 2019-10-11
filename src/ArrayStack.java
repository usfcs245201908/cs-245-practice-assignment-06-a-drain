import java.util.Arrays;

public class ArrayStack<T> implements Stack {

    int top;
    Object[] a;

    public ArrayStack(){
        top = -1;
        a = new Object[10];
    }

    public boolean empty(){
       return top == -1;
    }

    private void growArray(){
        Object[] copy = Arrays.copyOfRange(a, 0, a.length*2);
        a = copy;
    }

    public void push(Object item) {
        if(a.length-1 == top){
            growArray();
        }
        a[++top] = item;
    }

    public Object pop() throws Exception {
        if(empty()) throw new Exception("Stack is empty");
        return a[top--];
    }

    public Object peek() throws Exception {
        if(empty()) throw new Exception("Stack is empty");
        return a[top];
    }

    public static void main(String[] args) throws Exception {
        ArrayStack stack = new ArrayStack();
        ArrayQueue queue = new ArrayQueue();
        String randomString = "Hello world!";

        for (int i = 0; i < 500; i++) {
            queue.enqueue(randomString);
            stack.push(randomString);
        }
        boolean emptiedEarly = false;
        for (int i = 0; i < 500; i++) {
            if ( queue.empty() || stack.empty()) {
                emptiedEarly = true;
            }
            queue.dequeue();
            stack.pop();
        }
        if (queue.empty() && stack.empty() && ! emptiedEarly) {
            System.out.println("[+20%] Stack and Queue appear to resize correctly.");
        } else {
            System.out.println("[ XX ] Stack or Queue do not resize correctly.");
        }
    }

}
