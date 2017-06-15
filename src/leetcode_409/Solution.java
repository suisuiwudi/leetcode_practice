package leetcode_409;

import java.util.HashSet;

public class Solution {
    private HashSet<Character> set;
    public int longestPalindrome(String s) {
        int count = 0;
        set = new HashSet();
        for (int i = 0 ; i < s.length(); i++){
            if (set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
                count += 2;
            } else {
                set.add(s.charAt(i));
            }
        }
        if (set.size() > 0){
            return count + 1;
        } else 
            return count;
    }
}