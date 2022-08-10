import java.util.function.Predicate;
import java.util.function.Function;

public class Cons<E> {
    // The item inside this list node
    public E v;
    // The next element, null if there is none
    public Cons<E> next;

    // Constructor
    public Cons(E v, Cons<E> next) {
        this.v = v;
        this.next = next;
    }

    // Returns a new Cons by applying Function function on all elements
    public <R> Cons <R> map(Function <E,R> function) {
        Cons<R> tmp = new Cons<>(function.apply(this.v), null);
        if (next != null){
            tmp.next = this.next.map(function);
        }
        return tmp;
    }
    // Returns a new Cons containing all elements that match Predicate predicate
    public Cons <E> filter(Predicate <E> predicate) {
        Cons<E> tmp = new Cons<E>(null,null);
        Cons<E> head = this;

        while(head != null){
            if(predicate.test(head.v)){
                tmp.v = head.v;
                if(head.next != null){
                    tmp.next = head.next.filter(predicate);
                }
                return tmp;
            }
            head = head.next;
        }
        return null;
    }


}
