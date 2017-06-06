package leetcode_64;

public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] opt = new int[m][n];
        opt[0][0] = grid[0][0];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 && j == 0) continue;
                else if (i == 0) opt[i][j] = opt[i][j-1];
                else if (j == 0) opt[i][j] = opt[i-1][j];
                else opt[i][j] = Math.min(opt[i-1][j], opt[i][j-1]);
                opt[i][j] += grid[i][j];
            }
        }
        return opt[m-1][n-1];
    }
}