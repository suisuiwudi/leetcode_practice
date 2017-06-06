package leetcode_532;

import java.util.HashMap;
import java.util.TreeSet;

public class Solution {
    private HashMap<Integer, Integer> valCounts;
    private TreeSet<Integer> vals; 
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        vals = new TreeSet();
        valCounts = new HashMap();
        for (int i = 0; i < nums.length; i++){
            vals.add(nums[i]);
            valCounts.put(nums[i],valCounts.getOrDefault(nums[i], 0) + 1);
        }
        int ans = 0;
        for (int i : vals){
            if (valCounts.containsKey(i) && valCounts.containsKey(i + k)){
                if (k == 0 && valCounts.get(i) == 1) continue; 
                ans++;
            }
        }
        return ans;
    }
}