package leetcode_485;

public class Solution {
    private int ans;
    private int now;
    public int findMaxConsecutiveOnes(int[] nums) {
        ans = 0;
        now = 0;
        for ( int i = 0; i<nums.length; i++)
        if (nums[i] == 1){
            now++;
            if (now > ans) ans=now;
        }
        else{
            if (now > ans) ans=now;
            now = 0;
        }
        return ans;
    }
}