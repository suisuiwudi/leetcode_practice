package leetcode_363;

import java.util.TreeSet;

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = Math.min(matrix.length, matrix[0].length);
        int n = Math.max(matrix.length, matrix[0].length);
        int ans = Integer.MIN_VALUE;
        boolean ratate = false;
        if (matrix.length > matrix[0].length) ratate = true;
        for (int i = 0; i < m; i++){
            int[] sum = new int[n];
            for (int j = i; j < m; j++){
                int val = 0;
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                for (int index = 0; index < n; index++){
                    sum[index] += ratate? matrix[index][j] : matrix[j][index];
                    val += sum[index];
                    Integer res = set.ceiling(val - k);
                    if (res != null){
                        ans = Math.max(val - res, ans);
                    }
                    set.add(val);
                }
            }
        }
        return ans;
    }
}