package leetcode_496;

import java.util.HashMap;

public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        
        HashMap<Integer,Integer> a = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++){
            a.put(nums[i],i);
        }
        int[] ans = new int[findNums.length];
        for (int i = 0 ; i < findNums.length; i++){
            int index = a.get(findNums[i]) + 1;
            while (index < nums.length && nums[index] < findNums[i]){
                index++;
            }
            if (index == nums.length){
                ans[i] = -1;
            }else if (nums[index] > findNums[i])
                ans[i] = nums[index];
        }
        return ans;
    }
}