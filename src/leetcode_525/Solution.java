package leetcode_525;

import java.util.HashMap;

public class Solution {
    private HashMap<Integer, Integer> map;
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int ans = 0;
        map = new HashMap();
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                nums[i] = -1;
            }
            sum += nums[i];
            if (!map.containsKey(sum)){
                map.put(sum,i);
            } else {
                ans = Math.max(i - map.get(sum), ans);
            }
        }
        return ans;
    }
}