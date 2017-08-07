package leetcode_417;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return new ArrayList();
        int m = matrix[0].length;
        boolean[][] PacificWater = new boolean[n][m];
        boolean[][] AtlanticWater = new boolean[n][m];

        for (int i = 0; i < n; i++){
            if (!PacificWater[i][0]) {
                PacificWater[i][0] = true;
                WaterThrough(matrix, PacificWater, i, 0);
            }
            if (!AtlanticWater[i][m-1]){
                AtlanticWater[i][m-1] = true;
                WaterThrough(matrix, AtlanticWater,i , m - 1);
            }
        }
        
        for (int i = 0; i < m; i++){
            if (!PacificWater[0][i]){
                PacificWater[0][i] = true;
                WaterThrough(matrix, PacificWater,0,i);
            }
            if (!AtlanticWater[n -1][i]){
                AtlanticWater[n -1][i] = true;
                WaterThrough(matrix, AtlanticWater, n - 1, i);
            }
        }
        List<int[]> ans = new ArrayList();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (PacificWater[i][j] && AtlanticWater[i][j]){
                    ans.add(new int[]{i,j});
                }
            }
        }
        return ans;
    }
    public void WaterThrough(int[][] matrix, boolean[][] water, int x, int y){
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};
        for (int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextX >= matrix.length || nextY < 0 || nextY >= matrix[0].length){
                continue;
            }
            if (water[nextX][nextY]){
                continue;
            }
            if (matrix[nextX][nextY] < matrix[x][y]){
                continue;
            }
            water[nextX][nextY] = true;
            WaterThrough(matrix,water, nextX, nextY);
        }
    }
}
