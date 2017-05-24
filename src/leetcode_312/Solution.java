package leetcode_312;

public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int opt[][] = new int[n+2][n+2];
        int[] val = new int[n+2];
        for (int i = 0; i < n; i++)
            val[i+1] = nums[i];
        val[0] = 1;
        val[n+1] = 1;
        for (int l = 2; l < n + 2; l++)
            for (int i = 0; i < n + 2 - l; i++){
                int j = i + l;
                for (int k = i + 1; k < j; k++)
                    opt[i][j] = Math.max(opt[i][j],opt[i][k]+opt[k][j]+val[i]*val[k]*val[j]);
            }
        return opt[0][n+1];
    }
}