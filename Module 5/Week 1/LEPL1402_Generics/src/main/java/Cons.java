import org.jetbrains.annotations.NotNull;

public class Cons {
    // The item inside this list node
    public int v;
    // The next element, null if there is none
    public Cons next;

    // Constructor
    public Cons(int v, Cons next) {
        this.v = v;
        this.next = next;
    }

    // Returns a new Cons by applying function f on all elements
    public Cons map( F f) {
        Cons tmp = new Cons(f.apply(v), null);
        if (next != null) {
            tmp.next = this.next.map(f);
        }
        return tmp;
    }

    // Returns a new Cons containing all elements that match predicate p
    public Cons filter(P p) {
        Cons tmp = new Cons(0, null);
        Cons head = this;

        while (head != null) {
            if (p.filter(head.v)) {
                tmp.v = head.v;
                if (head.next != null) {
                    tmp.next = head.next.filter(p);
                }
                return tmp;
            }
            head = head.next;
        }
        return null;
    }


}