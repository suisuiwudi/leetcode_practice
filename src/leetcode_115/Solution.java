package leetcode_115;

class Solution {
    public int numDistinct(String s, String t) {
        int[][] ans = new int[s.length()+1][t.length()+1];
        for (int i = 0; i < s.length(); i++){
            ans[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++){
            for (int j = 1; j <= t.length(); j++){
                if (s.charAt(i-1) == t.charAt(j-1)){
                    ans[i][j] = ans[i-1][j-1] + ans[i-1][j];
                } else {
                    ans[i][j] = ans[i-1][j];
                }
            }
        }
        return ans[s.length()][t.length()];
    }
}