package leetcode_576;

class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        long[][][] paths = new long[2][m][n];
        int step = 0;
        while (step < N){
            int oldstep = step % 2;
            int newstep = (++step) % 2;
            for (int x = 0; x < m; x++){
                for (int y = 0; y < n; y++){
                    paths[newstep][x][y] = ((x == 0 ? 1 : paths[oldstep][x-1][y])
                        + (x == m - 1 ? 1 : paths[oldstep][x+1][y])
                        + (y == 0 ? 1 : paths[oldstep][x][y-1])
                        + (y == n - 1 ? 1 : paths[oldstep][x][y+1])) % 1000000007;           
                }
            }
        }
        return (int)paths[N % 2][i][j];
    }
}
