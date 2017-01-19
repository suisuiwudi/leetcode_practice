package leetcode_236;

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
        if (root == null) return null;
        if (root == p || root == q) return root; 
        TreeNode tmp_left = lowestCommonAncestor(root.left, p , q);
        TreeNode tmp_right = lowestCommonAncestor(root.right , p ,q);
//        if (tmp_left == null && tmp_right == null) return null;
        if (tmp_right == null) return tmp_left;
        if (tmp_left == null) return tmp_right;
        return root;
        
    }
}