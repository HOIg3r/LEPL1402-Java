import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;


/**
 * Question:
 *
 * You are asked to clean a increasing sorted linked List (see the TODO below)
 * Cleaning the linkedList means keeping only one occurrence of each value.
 *
 * For instance cleaning: 3,3,3,4,5,5,6,6,6,7,9,9,9,9,10,10
 * Gives: 3,4,5,6,7,9,10
 *
 * Your algorithm should execute in Theta(n)
 * where n are the number of elements in the original list
 *
 */
public class CleanLinkedList {

    Node first = null;
    Node last = null;

    public void add(int v) {
        if (first == null && last == null){
            first = new Node(v,null);
            last = first;
            return;
        }if(v < first.v){
            first = new Node(v,first);
            return;
        }
        Node current = first;
        while (current.v < v){
            if (current.next == null){
                current.next = new Node(v,null);
                last = current.next;
                return;
            }
            current = current.next;
        }
        
    }

    public void add(int ... values) {
        for (int v: values) {
            add(v);
        }
    }


    /**
     * Given the increasingly sorted list, it removes the duplicates
     * @return an increasingly sorted list containing the same set
     *         of elements as list but without duplicates.
     */
    public CleanLinkedList clean() {
        Node current = first;
        while (current != last){
            if (current.v == current.next.v){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return this;
    }


    class Node {
        int v;
        Node next;
        Node(int v, Node next) {
            this.v = v;
            this.next = next;
        }
    }


}

