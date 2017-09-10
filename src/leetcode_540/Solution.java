package leetcode_540;

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length / 2 - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid*2] != nums[mid*2+1]){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[2*left];
    }
}