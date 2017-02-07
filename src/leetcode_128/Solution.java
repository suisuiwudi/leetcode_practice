package leetcode_128;

import java.util.HashMap;
public class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for (int i : nums){
            if (!map.containsKey(i)){
                int left = 0 ;
                int right = 0;
                if (map.containsKey(i+1)){
                    right = map.get(i+1);
                }
                if (map.containsKey(i-1)){
                    left = map.get(i-1);
                }
                int sum = right + left + 1;
                map.put(i , sum);
                map.put(i - left, sum);
                map.put(i + right, sum);
                ans = Math.max(ans ,sum);
            }
        }
        return ans;
    }
    
}