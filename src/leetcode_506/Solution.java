package leetcode_506;

import java.util.HashMap;
import java.util.Arrays;
public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        HashMap<Integer,Integer> a = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++){
            a.put(nums[i],i);
        }
        Arrays.sort(nums);
        String[] ans = new String[nums.length];
        for (int i = 0 ; i < nums.length ; i++){
            if (i == nums.length - 1) ans[a.get(nums[i])] = "Gold Medal";
            else if (i == nums.length - 2) ans[a.get(nums[i])] = "Silver Medal";
            else if (i == nums.length - 3) ans[a.get(nums[i])] = "Bronze Medal";
            else {
                ans[a.get(nums[i])] = Integer.toString(nums.length - i);
            }
        }
        return ans;
    }
}