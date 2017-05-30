package leetcode_493;

public class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return countWhileMergeSort(nums, 0, n);
    }
    public int countWhileMergeSort(int[] nums, int start, int end){
        if (end - start <= 1) return 0;
        int mid = (start + end) / 2;
        int count = countWhileMergeSort(nums, start, mid) + countWhileMergeSort(nums, mid, end);
        int upperBound = mid;
        int j = mid;
        int[] cache = new int[end - start];
        for (int i =  start, cp = 0; i < mid; i++){
            while (upperBound < end && 2*(long) nums[upperBound] < (long)nums[i]) upperBound++;
            while (j < end && nums[j] < nums[i]) cache[cp++] = nums[j++];
            cache[cp++] = nums[i];
            count += upperBound - mid;
        }
        System.arraycopy(cache,0, nums, start, j - start);
        return count;
    }
}