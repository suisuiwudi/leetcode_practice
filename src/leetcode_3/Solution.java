package leetcode_3;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0 ;
        for (int i = 0, j = 0; i < s.length(); i++){
            int k = i - 1;
            for (; k > j ; k--){
                if (s.charAt(k) == s.charAt(i)) {
                    break;
                }
            }
            j = k;
            ans = Math.max(ans,i-j);
        }
        return ans;
    }
}