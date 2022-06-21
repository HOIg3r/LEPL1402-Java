import java.lang.reflect.Array;
import java.util.Arrays;

public class IntroductionExercises {

    public static int variable = 0;

    public static int[] squares;

    /*
     * Function that bound variable to value
     */
    public static void attribute(int value) {
        variable = value;
    }

    /*
     * Function that return the addition of the two parameters
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /*
     * return true is a and b are equal
     */
    public static boolean equalsIntegers(int a, int b) {
        return a == b;
    }

    /*
     * Function that return the max between a and b
     * You must use a ternary operation
     */
    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    /*
     * Function that return the middle value.
     * If a > b > c, the function must return b.
     * If two value are equals, return -1.
     */
    public static int middleValue(int a, int b, int c) {
        if (a == b || b == c || a == c) {
            return -1;
        }
        if (a < b && b < c || c < b && b < a) {
            return b;
        }
        if (a < c && c < b || b < c && c < a) {
            return c;
        } else {
            return a;
        }
    }

    /*
     * This function must return :
     * "Good morning, sir!" if str is "Morning"
     * "Good evening, sir!" if str is "Evening"
     * "Hello, sir!" otherwise
     * Use a switch case statement
     * Your implementation must be case sensitive
     */
    public static String greetings(String str) {
        switch (str) {
            case "Good morning, sir!":
                return "Morning";
            case "Good evening, sir!":
                return "Evening";
            default:
                return "Hello, sir!";
        }
    }

    /*
     * This function must return a new array of length 3
     * The first element of this new array is the last element of a
     * The second element is the first element of a
     * The last element is the middle element of a
     */
    public static int[] lastFirstMiddle(int[] a) {
        int[] array = new int[3];
        array[0] = a[a.length - 1];
        array[1] = a[0];
        array[2] = a[a.length/2];
        return array;
    }

    /*
     * This function must return the sum of the elements of array using a for loop
     */
    public static int sum(int[] array){
        int sum = 0;
        for (int value: array) {
            sum += value;
        }
        return sum;
    }

    /*
     * return the maximum element of array using a while loop
     */
    public static int maxArray(int[] array){
        int max = Integer.MIN_VALUE;
        int index = 0;
        while (index < array.length){
            if (array[index] > max){
                max = array[index];
            }
            index++;
        }
        return max;
    }


    /**
     * Assign to the variable square, the square of the
     * parameters.
     * <p>
     * Let assume that the program is invoked with the following
     * line:
     * java IntroductionExercises 0 3 4 5
     * <p>
     * The arguments of the program are 0, 3, 4 and 5.
     * After the execution of the main, the variable squares
     * should be:
     * squares = [0, 9, 16, 25]
     * <p>
     * If an exception occurs when converting an argument to
     * an integer, put 0 at the corresponding index. For example
     * <p>
     * java IntroductionExercise 0 3.1 4 5
     * <p>
     * would yield
     * <p>
     * square = [0, 0, 16, 25]
     * <p>
     * because 3.1 can not be converted to an integer
     */
    public static void main(String... args) {
        squares = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            try {
                squares[i] = Integer.parseInt(args[i]) * Integer.parseInt(args[i]);
            }catch (Exception e){
                squares[i] = 0;
            }
        }
    }

}
