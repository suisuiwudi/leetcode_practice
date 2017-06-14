package leetcode_575;

import java.util.HashSet;

public class Solution {
    private HashSet<Integer> set;
    public int distributeCandies(int[] candies) {
        set = new HashSet();
        for (int num : candies){
            set.add(num);
        }
        return Math.min(set.size(), candies.length / 2);
    }
}