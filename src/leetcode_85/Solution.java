package leetcode_85;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        if (m == 0) return 0;
        int[] heights = new int[m];
        Arrays.fill(heights, 0);
        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (matrix[i][j] == '0'){
                    heights[j] = 0;
                } else {
                    heights[j]++;
                }
            }
            ans = Math.max(ans, largestRectangleArea(heights));
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int ans = 0;
        for (int i = 0; i <= heights.length; i++){
            while (!stack.isEmpty() && (i == heights.length || heights[i] < heights[stack.peek()])){
                int lowH = heights[stack.pop()];//height of this block, heights of the previous one between this one are all higher than this
                int left = -1;
                if (!stack.isEmpty()){
                    left = stack.peek();
                }
                ans = Math.max(ans,lowH * (i - left - 1));
            }
            stack.push(i);
        }
        return ans;
    }
}