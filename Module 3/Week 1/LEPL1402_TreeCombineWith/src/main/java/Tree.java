public class Tree {

    public Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Tree combineWith(Tree o) {
        if (o == null) {
            throw new NullPointerException();
        }
        return new Tree(combine(this.root, o.root));
    }

    public Node combine(Node m, Node o) {
        if (m == null) {
            return copy(o);
        }
        if (o == null) {
            return copy(m);
        }
        Node newNode = new Node(m.val += o.val);
        if (o.left != null) {
            if (m.left == null) {
                newNode.left = copy(o.left);
            } else {
                newNode.left = combine(m.left, o.left);
            }
        } else if (m.left != null) {
            newNode.left = copy(m.left);
        }

        if (o.right != null) {
            if (m.right == null) {
                newNode.right = copy(o.right);
            } else {
                newNode.right = combine(m.right, o.right);
            }
        } else if (m.right != null) {
            newNode.right = copy(m.right);
        }

        return newNode;
    }

    public Node copy(Node n) {
        if (n == null) {
            return null;
        }
        Node newNode = new Node(n.val);
        if (n.left != null) {
            newNode.left = copy(n.left);
        }
        if (n.right != null) {
            newNode.right = copy(n.right);
        }
        return newNode;
    }

}