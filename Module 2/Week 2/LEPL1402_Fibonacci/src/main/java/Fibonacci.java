public class Fibonacci {


    public static int fiboRecursive(int index){
        if (index == 0){
            return 0;
        } else if (index == 1) {
            return 1;
        }
        else {
            return fiboRecursive(index - 1) + fiboRecursive(index - 2);
        }
    }


    public static int fiboIterative(int index){
        if (index == 0){
            return 0;
        } else if (index == 1) {
            return 1;
        }

        int a = 0;
        int b = 1;
        for (int i = 0; i < index; i++) {
            int c = a;
            a = b;
            b = c + b;
        }
        return a;
    }

}
