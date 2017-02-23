package leetcode_14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String com = strs[0];
        for (int i = 1; i < strs.length; i++){
            int j = 0;
            while (j<strs[i].length() && j<com.length() && com.charAt(j) == strs[i].charAt(j)) j++;
            com = com.substring(0,j);
        }
        return com;
    }
}