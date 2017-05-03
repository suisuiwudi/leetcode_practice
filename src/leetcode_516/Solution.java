package leetcode_516;

public class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[][] opt = new int[n][n];
        for (int i = 0; i < n; i++){
            opt[i][i] = 1;
        }
        int ans = 1;
        for (int l = 2; l <= n; l++){
            for (int i = 0 ; i < n - l + 1; i++){
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)){
                    opt[i][j] = opt[i+1][j-1] + 2;
                }
                opt[i][j] = Math.max(opt[i+1][j],opt[i][j]);
                opt[i][j] = Math.max(opt[i][j-1],opt[i][j]);
                ans = Math.max(ans,opt[i][j]);
            }
        }
        return ans;
    }
}
