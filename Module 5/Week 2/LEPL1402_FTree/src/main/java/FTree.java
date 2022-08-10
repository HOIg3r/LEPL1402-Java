import java.util.function.Function;

public abstract class FTree<A> {

    public abstract A value();
    public abstract FTree<A> left();
    public abstract FTree<A> right();

    public final int depth() {
        if(this instanceof Leaf){
            return 0;
        }
        return 1 + right().depth();
    }

    public final <B> FTree<B> map(Function<A,B> f) {
    }

}
