package leetcode_491;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        Set<List<Integer>> Hash_ans = new HashSet<List<Integer>>();
        int n = nums.length;
        for (int i = 0 ; i < n ; i++){
            List<Integer> one_num = new ArrayList<Integer>();
            one_num.add(nums[i]);
            Hash_ans.addAll(findSubsequence(one_num, i + 1, nums));
        }
       
        List<List<Integer>> ans = new ArrayList<List<Integer>>(Hash_ans);
        return ans;
    }
    
    public Set<List<Integer>> findSubsequence(List<Integer> list_now, int head, int[] nums){
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<List<Integer>>();
        List<Integer> new_digit = new ArrayList<Integer>();
        for (int i = head; i < n ; i++){
            int tmp = list_now.get(list_now.size()-1);
            if (nums[i] >= tmp){
                    list_now.add(nums[i]);
                	ans.add(new ArrayList<Integer>(list_now));
                    new_digit.add(nums[i]);
                    ans.addAll(findSubsequence(list_now, i + 1 , nums));
                    list_now.remove(list_now.size()-1);
            }           
        }
        
        return ans;
    }
}