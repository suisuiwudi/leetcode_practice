package leetcode_11;

public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left < right){
            int h = Math.min(height[left], height[right]);
            ans = Math.max(ans,h * (right - left));
            while (height[left] <= h && left < right) left++;
            while (height[right] <= h && left < right) right--;
        }
        return ans;
    }
}