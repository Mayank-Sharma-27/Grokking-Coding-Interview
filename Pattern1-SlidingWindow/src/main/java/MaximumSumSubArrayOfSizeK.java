public class MaximumSumSubArrayOfSizeK {

    // pseudo code
    // Init 2 pointers to 0  maxSum arr[0] and window sum =0
    // Since we are given the length of the subarray we can use sliding window to solve this problem in O(n) time
    // iterate end variable till it becomes equal to arr.length
    // when the window size becomes k calculate max and subtract that start element from the sum and increase the start
    // return max;

    public static int findMaxSumSubArray(int k, int[] arr) {
        int start =0;
        int end =0;
        int maximumSum =arr[0];
        int windowSum =0;
        while(end < arr.length){
            windowSum += arr[end];
            if(end - start +1 >= k){
                maximumSum = Math.max(windowSum , maximumSum);
                windowSum -= arr[start];
                start++;
            }
            end++;

        }

        return maximumSum;
    }

}
