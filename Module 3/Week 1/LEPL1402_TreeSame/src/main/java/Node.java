public class Node {

    public int val;
    public Node left;
    public Node right;

    public Node(int val){
        this.val = val;
    }

    public boolean isLeaf(){
        return this.left == null && this.right == null;
    }

    @Override
    public boolean equals(Object o){
        if(this.getClass() != o.getClass()){
            return false;
        }

        if (this.isLeaf() && ((Node) o).isLeaf()){
            return this.val == ((Node) o).val;
        }

        if(!this.isLeaf() && !((Node) o).isLeaf()){
            return this.right.equals(((Node) o).right) && this.left.equals(((Node) o).left);
        }
        return false;
    }
}