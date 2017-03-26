package leetcode_78;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new LinkedList();
        List<Integer> newList = new LinkedList();
        ans.add(newList);
        for (int i = 0; i < n; i++){
            int ansLength = ans.size();
            for (int j = 0; j < ansLength; j++){
                newList = new LinkedList(ans.get(j));
                newList.add(nums[i]);
                ans.add(newList);
            }
        }
        return ans;
    }
}