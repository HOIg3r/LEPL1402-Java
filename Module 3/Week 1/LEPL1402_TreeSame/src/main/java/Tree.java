public class Tree {

    public Node root;

    public Tree(Node root){
        this.root = root;
    }

    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }

        if(this.getClass() != o.getClass()){
            return false;
        }

        if(this.root == null && ((Tree) o).root == null){
            return true;
        }

        if(this.root == null || ((Tree) o).root == null){
            return false;
        }


        if(this.root.val == ((Tree) o).root.val){
            return this.root.right.equals(((Tree) o).root.right) && this.root.left.equals(((Tree) o).root.left);
        }
        return false;
    }

}