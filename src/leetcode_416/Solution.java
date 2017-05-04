package leetcode_416;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        boolean[] opt = new boolean[sum/2 + 1];
        opt[0] = true;
        for (int i = 0; i < nums.length; i++){
            for (int j = sum/2; j >= nums[i] ; j--){
                opt[j] = opt[j] || opt[j - nums[i]];
            }
        }
        return opt[sum/2];
    }
}
