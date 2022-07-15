import java.util.LinkedList;

public class MyStack<E> {

    private LinkedList<E> queue;

    /*
     * Constructor
     */
    public MyStack() {
        this.queue = new LinkedList<>();
    }

    /**
     * Push an element on the stack
     *
     * @param elem the Element to push
     */
    public void push(E elem) {
        this.queue.add(elem);
    }

    /**
     * Remove the element at the top of the stack
     *
     * @return The element at the top of the stack
     */
    public E pop() {
        return this.queue.remove(this.queue.size()-1);
    }

    /**
     * Look at the element at the top of the stack
     *
     * @return The element at the top of the stack
     */
    public E peek() {
        E tmp = pop();
        push(tmp);
        return tmp;
    }

    /**
     * Is the stack empty
     *
     * @return True if there is no element in the stack
     *         and false otherwise
     */
    public boolean empty() {
        return this.queue.isEmpty()
    }

}
