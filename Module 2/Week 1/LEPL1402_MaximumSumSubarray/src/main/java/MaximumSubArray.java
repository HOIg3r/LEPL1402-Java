public class MaximumSubArray {


    /**
     * Find the contiguous subarray with the maximal sum
     *
     * @param a a non-empty array
     * @return A triplet (sum, start, end) with sum the sum of the subarray and `start` and `end` the
     *         start and end of the subarray
     *
     * For example for the array [-2,1,-3,4,-1,2,1,-5,4] your method should return [6, 3, 6]
     */
    public static int[] maxSubArray(int[] a){
        int count = Integer.MIN_VALUE;
        int bestEnd = 0;
        int start = 0;
        int end = 0;
        int s = 0;


        for (int i = 0; i < a.length; i++) {
            bestEnd += a[i];

            if(count < bestEnd){
                count = bestEnd;
                start = s;
                end = i;
            }
            if (bestEnd < 0){
                bestEnd = 0;
                s =i+1;
            }
        }
        return new int[]{count, start,end};
    }
}
