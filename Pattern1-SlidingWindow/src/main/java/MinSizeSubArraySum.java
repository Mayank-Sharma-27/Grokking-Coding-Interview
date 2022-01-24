public class MinSizeSubArraySum {
    // pseudo code
    // Init 2 pointers to 0  min to Integer.MAX_VALUE and window sum =0
    // Since we are given the length of the subarray we can use sliding window to solve this problem in O(n) time
    // iterate end variable till it becomes greater than or equal to S
    // do a while loop while sum is greater than S keep increasing start and calculate window size compare with min value
    // return min;
    public static int findMinSubArray(int S, int[] arr) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while (end < arr.length) {
            sum += arr[end];

            if (sum >= S) {
                min = Math.min(end - start + 1, min);

                while (start <= end && sum >= S) {
                    sum -= arr[start];
                    start++;
                    if (sum >= S) {
                        min = Math.min(end - start + 1, min);
                    }
                }
            }
            end++;

        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        }

        return min;
    }

}
