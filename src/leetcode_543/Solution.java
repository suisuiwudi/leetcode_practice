package leetcode_543;

import data_structure.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        Height(root);
        return ans;
    }
    public int Height(TreeNode root){
        if (root == null) return 0;
        int left = Height(root.left);
        int right = Height(root.right);
        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    }
}
