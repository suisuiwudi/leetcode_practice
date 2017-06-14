package leetcode_565;

import java.util.Arrays;

public class Solution {
    public int arrayNesting(int[] nums) {
        int[] used = new int[nums.length];
        Arrays.fill(used,-1);
        int ans = 0;
        for (int i = 0 ; i < nums.length; i++){
            if (used[nums[i]] == -1){
                int tmp = nums[i];
                int count = 0;
                while (used[nums[tmp]] == -1){
                    used[nums[tmp]] = 0;
                    tmp = nums[tmp];
                    count++;
                }
                ans = Math.max(count, ans);
            }
        }
        return ans;
    }
}