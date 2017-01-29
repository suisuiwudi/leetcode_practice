package leetcode_124;

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
    private int maxMum;
    public int maxPathSum(TreeNode root) {
        maxMum = Integer.MIN_VALUE;
        maxPathRootSum(root);
        return maxMum;
    }
    public int maxPathRootSum(TreeNode root){
        if (root == null) return 0;
        int pathLeft = maxPathRootSum(root.left);
        int pathRight = maxPathRootSum(root.right);
        int maxPathLeft = Math.max(0,pathLeft);
        int maxPathRight = Math.max(0,pathRight);
        maxMum = Math.max(maxMum,maxPathLeft + maxPathRight + root.val);
        return Math.max(maxPathLeft,maxPathRight) + root.val;
    }
}