package leetcode_74;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = m*n-1;
        while (left <= right){
            int mid = (left + right) / 2;
            int num = matrix[mid/m][mid%m];
            if (num == target) return true;
            else if (num < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}