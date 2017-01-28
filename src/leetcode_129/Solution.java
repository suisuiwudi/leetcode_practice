package leetcode_129;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        int[] ans = sumNumsLevels(root);
        return ans[0];
    }
    public int[] sumNumsLevels(TreeNode root){
        int sum[] = new int[2];
        sum[0] = 0;
        sum[1] = 0;
        if (root == null) return sum;
        if (root.right == null && root.left == null){
            sum[0] = root.val;
            sum[1] = 1;
            return sum;
        }
        int[] sum_left = sumNumsLevels(root.left);
        int[] sum_right = sumNumsLevels(root.right);
        sum[1] = ( sum_left[1]+sum_right[1] )*10;
        sum[0] = sum[1] * root.val + sum_left[0] + sum_right[0];
        return sum;
    }
}