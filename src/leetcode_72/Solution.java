package leetcode_72;

import java.util.Arrays;

public class Solution {
    public int minDistance(String word1, String word2) {
        char[] words1 = word1.toCharArray();
        char[] words2 = word2.toCharArray();
        int n = word1.length();
        int m = word2.length();
        int[][] opt = new int[n + 1][m + 1];
        for (int[] row: opt){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 0; i <= n; i++){
            opt[i][0] = i;
        }
        for (int i = 0; i <= m; i++){
            opt[0][i] = i;
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (words1[i] == words2[j])
                    opt[i+1][j+1] = opt[i][j];
                else
                    opt[i+1][j+1] = Math.min(Math.min(opt[i][j+1], opt[i+1][j]), opt[i][j]) + 1;
            }
        }
        return opt[n][m];
    }
}