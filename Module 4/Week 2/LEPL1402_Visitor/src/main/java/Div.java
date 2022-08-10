public class Div extends Node implements Visitable {
    public Div(Visitable left, Visitable right) {
        super(left, right);
    }

    @Override
    public int accept(Visitor visitor) {
        if(super.getRight().accept(visitor) == 0){
            throw new IllegalArgumentException();
        }
        return super.getLeft().accept(visitor) / super.getRight().accept(visitor);
    }
    // YOUR CODE HERE
}
