package leetcode_494;

public class Solution_1 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if (S < -sum || S > sum) return 0;
        int old[] = new int[2*sum+1];
        int now[] = new int[2*sum+1];
        old[sum] = 1;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++){
            curSum += nums[i];
            now = new int[2*sum+1];
            for (int j = sum - curSum; j <= sum + curSum; j++){
                if (j-nums[i] >= 0) now[j] += old[j-nums[i]];
                if (j+nums[i] <= 2*sum) now[j] += old[j+nums[i]];
            }
            old = now;
        }
        return now[sum+S];
    }
}