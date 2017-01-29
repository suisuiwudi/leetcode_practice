package leetcode_110;

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
    public boolean isBalanced(TreeNode root) {
        int[] ans = balancedHeight(root);
        return ans[0] == 1;
    }
    public int[] balancedHeight(TreeNode root){
        int[] ans = new int[2];
        ans[0] = 1;
        ans[1] = 0;
        if (root == null) return ans;
        if (root.right == null && root.left == null){
            ans[0] = 1;
            ans[1] = 1;
            return ans;
        }
        int[] left = balancedHeight(root.left);
        int[] right = balancedHeight(root.right);
        ans[1] = Math.max(left[1],right[1]) + 1;
        if (left[0] == 1 && right[0] == 1 && (Math.abs(left[1]-right[1])<=1))
            ans[0] = 1;
        else
            ans[0] = 0; 
        return ans;
    }
}