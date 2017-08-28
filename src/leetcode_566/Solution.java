package leetcode_566;

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int oriR = nums.length;
        int oriC = nums[0].length;
        if (oriR * oriC != r*c) return nums;
        int[][] ans = new int[r][c];
        int index = 0;
        for (int i = 0; i < oriR; i++){
            for (int j = 0; j < oriC; j++){
                ans[index / c][index % c] = nums[i][j];
                index++;
            }
        }
        return ans;
    }
}