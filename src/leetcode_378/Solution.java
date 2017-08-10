package leetcode_378;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix[0].length - 1];
        while (left <= right){
            int mid = 0;
            if (left == right) mid = left; 
            else mid = (left + right) / 2;
            int count = countSmallerOrEqual(matrix,mid);
            
            if (count < k){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            
        }
        return left;
    }
    public int countSmallerOrEqual(int[][] matrix, int target){
        int count = 0;
        for (int i = 0; i < matrix.length; i++){
            if (matrix[i][0] > target) continue;
            if (matrix[i][matrix[0].length - 1] <= target){
                count += matrix[0].length;
                continue;
            }
            int left = 0;
            int right = matrix[0].length - 1;
            while (left <= right){
                int mid = (left + right) / 2;
                if (matrix[i][mid] > target){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            count += left;
        }
        return count;
    }
}