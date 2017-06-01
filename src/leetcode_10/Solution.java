package leetcode_10;

public class Solution {
    public boolean isMatch(String s, String p) {
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 1; i < p.length(); i++){
            if (pc[i] == '*')
                dp[0][i+1] = dp[0][i-1];
        }
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < p.length(); j++){
                if (pc[j] == '.' || pc[j] == sc[i]){
                    dp[i+1][j+1] = dp[i][j];
                }
                if (pc[j] == '*' && j > 0){
                    if (pc[j-1] != sc[i] && pc[j-1] != '.'){
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = dp[i+1][j] || dp[i+1][j-1] || dp[i][j+1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}