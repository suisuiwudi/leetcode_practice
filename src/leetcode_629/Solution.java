package leetcode_629;

class Solution {
    public int kInversePairs(int n, int k) {
        int[][] delta = new int[n][k+1];
        int[][] sum = new int[n][k+1];
        delta[0][0] = 1;
        for (int i = 0; i <=k; i++){
            sum[0][i] = 1;
        }
        for (int i = 1; i < n; i++){
            for (int j = 0; j <= k; j++){
                if (i < j) delta[i][j] = (sum[i-1][j] - sum[i-1][j - i - 1]) % 1000000007;
                else delta[i][j] = sum[i-1][j];
                if (delta[i][j] < 0) delta[i][j] += 1000000007;
                if (j > 0) sum[i][j] = (sum[i][j-1] + delta[i][j]) % 1000000007;
                else sum[i][j] = delta[i][j];
            }
        }
        return delta[n-1][k];
    }
}
