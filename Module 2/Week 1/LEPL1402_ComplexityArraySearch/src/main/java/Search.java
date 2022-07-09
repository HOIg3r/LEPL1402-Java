import java.lang.reflect.Array;
import java.util.Arrays;

public class Search {

    /**
     * [1,2,3,4,5,6]
     *
     * @param tab is an ordered array of int.
     * @return index of elem or -1
     */
    public static int search(int[] tab, int elem) {
        int first = 0;
        int last = tab.length - 1;

        while (first <= last) {
            int mid = (first + last) / 2;
            if (elem == tab[mid]){
                return mid;
            } else if (elem < tab[mid]) {
                last = mid - 1;
            } else if (elem > tab[mid]) {
                first = mid + 1;
            }
            else return - 1;
        }
        return -1;
    }
}