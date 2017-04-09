package leetcode_324;

import java.util.PriorityQueue;

public class Solution {
    
    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;
        int right = nums.length - 1;
        int left = 0;
        int i = 0;
        while ( i <= right){
            if (nums[wiggleIndex(i,n)] < median ){
                swap(nums, wiggleIndex(left++,n), wiggleIndex(i++,n));
            } else if (nums[ wiggleIndex(i,n)] > median){
                swap(nums, wiggleIndex(i,n), wiggleIndex(right--,n));
            } else i++;
        }

    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num: nums){
            queue.add(num);
            if (queue.size() > k)
                queue.poll();
        }
        return queue.poll();
    }
    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    public int wiggleIndex(int index, int n){
        int bound = (n-1)/2;
        if (index > bound) return (n | 1) - (2*(index-bound));
        return  n - 1 - 2*index - (n + 1) % 2 ;
    }
}