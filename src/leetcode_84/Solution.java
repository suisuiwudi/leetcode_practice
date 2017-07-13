package leetcode_84;

import java.util.Stack;

public class Solution {
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