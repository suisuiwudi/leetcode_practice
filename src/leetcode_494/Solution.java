package leetcode_494;

public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        int tot_sum = 0;
        for (int i = 0 ; i < n; i++){
            tot_sum += nums[i];
        }
        
        int ans[][] = new int [n+1][tot_sum*2+1];
        int now_sum = 0;
        ans[0][tot_sum] = 1;
        for (int i = 0 ; i < n ; i++){
            for (int j = tot_sum-now_sum; j <= tot_sum+now_sum ; j++){
                ans[i+1][j+nums[i]] += ans[i][j];
                ans[i+1][j-nums[i]] += ans[i][j];
            }
            now_sum += nums[i];
        }
        if (S>tot_sum) return 0;
        return ans[n][tot_sum+S];
    }
}