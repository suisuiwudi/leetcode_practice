package leetcode_329;

public class Solution {
    private int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    private int ans;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        ans = 1;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                ans = Math.max(ans,helper(i,j,matrix, cache));
            }
        }
        return ans;
    }
    public int helper(int row, int col, int[][] matrix, int[][] cache){
        
        if (cache[row][col] != 0) return cache[row][col];
        int max = 1;
        for (int[] dir : dirs){
            int nextX = row + dir[0];
            int nextY = col + dir[1];
            if (nextX < 0 || nextX >= matrix.length || nextY < 0 || nextY >= matrix[0].length) continue;
            if (matrix[nextX][nextY] <= matrix[row][col]) continue;
            max = Math.max(max, 1 + helper(nextX, nextY, matrix, cache));
        }
        cache[row][col] = max; 
        return cache[row][col];
    }
}