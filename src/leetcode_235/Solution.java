package leetcode_235;

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (q.val < root.val && p.val <root.val) return lowestCommonAncestor(root.left, p, q);
        else if (q.val > root.val && p.val > root.val) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }
}