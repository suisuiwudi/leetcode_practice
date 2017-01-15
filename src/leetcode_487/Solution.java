package leetcode_487;

public class Solution {
    private int ans;
    private int now;
    public int findMaxConsecutiveOnes(int[] nums) {
        ans = 1;
        now = 0;
        int f[][] = new int[nums.length][2];
        if (nums[0] == 0){
            f[0][0]=0;
            f[0][1]=1;
        }
        else{
            f[0][0]=1;
            f[0][1]=0;
        }
        for ( int i = 1; i<nums.length; i++)
        if (nums[i] == 1){
            f[i][0]=f[i-1][0]+1;
            f[i][1]=f[i-1][1]+1;
            if (f[i][0]>ans) ans =f[i][0];
            if (f[i][1]>ans) ans =f[i][1];
        }
        else{
            f[i][0]=0;
            f[i][1]=f[i-1][0]+1;
            if (f[i][1]>ans) ans =f[i][1];
        }
        return ans;
    }
}