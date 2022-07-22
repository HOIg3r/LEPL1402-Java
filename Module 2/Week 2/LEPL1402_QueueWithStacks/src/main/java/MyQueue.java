import java.util.Stack;
import java.util.NoSuchElementException;

public class MyQueue<E> {

    Stack<E> s1;
    Stack<E> s2;

    private E front;

    /*
     * Constructor
     */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        this.front = null;
    }

    /**
     * Add an element to the end of the list
     *
     * @param elem The element to add
     */
    public void enqueue(E elem) {
        if(this.front == null){
            s1.add(elem);
            front = elem;
        }else {
            if(!s1.isEmpty() && s2.isEmpty()){
                while (!s1.isEmpty()){
                    s2.add(s1.pop());
                }
                s2.add(elem);
                while (!s2.isEmpty()){
                    s1.add(s2.pop());
                }
            } else if (!s2.isEmpty() && s1.isEmpty()) {
                s2.add(elem);
                while (!s2.isEmpty()){
                    s1.add(s2.pop());
                }
            }
            else{
                throw new RuntimeException();
            }
        }
    }

    /**
     * Remove the first element from the queue
     *
     * @return The oldest element in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public E dequeue() {
        if(s1.isEmpty() && s2.isEmpty()){
            throw new NoSuchElementException("The Queue is empty");
        }
        return s1.pop();
    }

    /**
     * Peek at the first element of the queue
     *
     * @return The first element of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public E peek() {
        if(s1.isEmpty() && s2.isEmpty()){
            throw new NoSuchElementException("The Queue is empty");
        }
        E tmp = s1.pop();
        s1.add(tmp);
        return tmp;
    }

    /**
     * @return true if the queue is empty
     */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

}
