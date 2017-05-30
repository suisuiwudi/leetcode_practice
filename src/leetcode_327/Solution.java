package leetcode_327;

public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; i++)
            sums[i + 1] = sums[i] + nums[i];
        return countWhileMergeSort(sums, 0, n + 1, lower, upper);
    }
    public int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper){
        if (end - start <= 1) return 0;
        int mid = (start + end) / 2;
        int count = countWhileMergeSort(sums, start, mid, lower, upper) + countWhileMergeSort(sums, mid,end, lower, upper);
        int lowerBound = mid, upperBound = mid;
        int j = mid;
        long[] cache = new long[end - start];
        for (int i = start, cp = 0; i < mid; i++){
            while (lowerBound < end && sums[lowerBound] - sums[i] < lower) lowerBound++;
            while (upperBound < end && sums[upperBound] - sums[i] <= upper) upperBound++;
            while (j < end && sums[j] < sums[i]) cache[cp++] = sums[j++];
            cache[cp++] = sums[i];
            count += upperBound - lowerBound; 
        }
        System.arraycopy(cache,0, sums, start, j - start);
        return count;
    }
}