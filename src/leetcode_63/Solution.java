package leetcode_63;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) return 0;
        int[][] sum = new int[m][n];
        sum[0][0] = 1;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (obstacleGrid[i][j] == 1) continue;
                if (i == 0 && j == 0) continue;
                else if (i == 0) sum[i][j] = sum[i][j-1];
                else if (j == 0) sum[i][j] = sum[i-1][j];
                else sum[i][j] = sum[i-1][j] + sum[i][j-1];
            }
        }
        return sum[m-1][n-1];
    }
}