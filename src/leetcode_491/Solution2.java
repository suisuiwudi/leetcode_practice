package leetcode_491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet();
        List<Integer> now = new ArrayList();
        findSub(ans, now, nums, 0);
        return new ArrayList(ans);
    }
    public void findSub(Set<List<Integer>> ans, List<Integer> now, int[] nums, int index){
        if (now.size() > 1){
            ans.add(new ArrayList(now));
        }
        for (int i = index; i < nums.length; i++){
            if (now.size() == 0 || nums[i] >= now.get(now.size()-1)){
                now.add(nums[i]);
                findSub(ans, now, nums, i + 1);
                now.remove(now.size() - 1);
            }
        }
    }
}