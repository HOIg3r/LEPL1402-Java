import java.util.Arrays;

public class FindPattern {

    /**
     * In this task you must find the first occurrence of a pattern in a
     * sequence.
     * This occurrence might also be **in a different order** than in 
     * the pattern.
     * 
     * For example, let:
     *      pattern = [1, 1, 3, 5]
     *      sequence = [3, 1, 2, 5, 1, 3, 1, 5, 1]
     *
     * Starting at index 3, we have the sub-sequence [5, 1, 3, 1] which
     * is the pattern reordered. Thus your method must return 3.
     * Note that the pattern also appears at index 4, but you must
     * return the first occurrence.
     * If the pattern is not in the sequence, you must return -1.
     *
     * @param pattern The pattern to look for
     * @param sequence The sequence to look in. Each element of the sequence is
     *        in the interval [0, 15]
     * @return The index of the first occurrence of the pattern in the
     *         sequence or -1 if the pattern is not in the sequence
     */
    public static int find(int [] pattern, int [] sequence) {
        int[] patterCopy = pattern.clone();
        Arrays.sort(patterCopy);

        for (int i = 0; i < sequence.length- pattern.length + 1; i++) {
            int[] slice = Arrays.copyOfRange(sequence,i,i+pattern.length);
            Arrays.sort(slice);
            if (Arrays.equals(slice, patterCopy)){
                return i;
            }
        }
        return -1;
    }
}
