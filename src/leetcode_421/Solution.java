package leetcode_421;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0; int mask = 0;
        for (int i = 31; i >=0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet();
            for (int num : nums){
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for (int prefix : set){
                if (set.contains(prefix ^ tmp)){
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}