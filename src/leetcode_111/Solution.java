package leetcode_111;

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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.right == null  && root.left == null) return 1;
        int minleft = minDepth(root.left);
        int minright = minDepth(root.right);
        if (minleft == 0) return minright + 1;
        if (minright == 0) return minleft + 1;
        return Math.min(minright,minleft) + 1;
    }
}