/**
 * Question:
 *
 * You are asked to implement the abstract data type RecursiveStack below.
 *
 * Your implementation can be an inner static class or a class below.
 * The factory method "makeRecursiveStack" returns a new instance of your implementation
 *
 * Once it is done, copy-paste the complete file in Inginious also with the imports
 *
 *
 * Feel free to add classes, methods or fields in the class but do not modify
 * the signature of existing code
 *
 */
public interface RecursiveStack {


    /**
     * Factory method
     * @return a new instance of your implementation of RecursiveStack
     */
    public static RecursiveStack makeRecursiveStack() {
        return new RecursiveStack.inner();
    }


    int size();

    int top();

    RecursiveStack removeTop();

    RecursiveStack addTop(int v);

    // TODO implement an (inner) class that implements the interface
    public class inner implements RecursiveStack{

        private int size;
        private int top;

        @Override
        public int size() {
            return size;
        }

        @Override
        public int top() {
            return top;
        }

        @Override
        public RecursiveStack removeTop() {
            return null;/**
 * Question:
 *
 * You are asked to implement the abstract data type RecursiveStack below.
 *
 * Your implementation can be an inner static class or a class below.
 * The factory method "makeRecursiveStack" returns a new instance of your implementation
 *
 * Once it is done, copy-paste the complete file in Inginious also with the imports
 *
 *
 * Feel free to add classes, methods or fields in the class but do not modify
 * the signature of existing code
 *
 */
public interface RecursiveStack {


    /**
     * Factory method
     * @return a new instance of your implementation of RecursiveStack
     */
    public static RecursiveStack makeRecursiveStack() {
        return new RecursiveStack.inner();
    }


    int size();

    int top();

    RecursiveStack removeTop();

    RecursiveStack addTop(int v);

    // TODO implement an (inner) class that implements the interface
    public class inner implements RecursiveStack{

        private int size;return 0;
        private int top;

        @Override
        public int size() {
            return size;
        }

        @Override
        public int top() {
            return top;
        }

        @Override
        public RecursiveStack removeTop() {
            return null;
        }

        @Override
        public RecursiveStack addTop(int v) {
            return null;
        }
    }


}


        }

        @Override
        public RecursiveStack addTop(int v) {
            return null;
        }
    }


}

