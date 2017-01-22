package leetcode_486;

public class Solution {
    public int best(int i, int j, int nums[]){
        if (i==j) return nums[i];
        return Math.max(nums[i]-best(i+1,j,nums),nums[j]-best(i,j-1,nums));
    }
    public boolean PredictTheWinner(int[] nums) {
        return best(0,nums.length-1,nums)>=0;
    }
}
