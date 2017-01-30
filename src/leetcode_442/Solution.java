package leetcode_442;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0 ; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) ans.add(index + 1);
            nums[index] = -nums[index];
        }
        return ans;
    }
}