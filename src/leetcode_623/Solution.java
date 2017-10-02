package leetcode_623;

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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        } else 
            return traversal(root,v,d,1);
    }
    public TreeNode traversal(TreeNode root, int v, int d, int level){
        if (root == null) return null;
        if (level + 1 == d){
            TreeNode left = new TreeNode(v);
            left.left = root.left;
            root.left = left;
            TreeNode right = new TreeNode(v);
            right.right = root.right;
            root.right = right;
        } else {
            root.left = traversal(root.left, v, d, level + 1);
            root.right = traversal(root.right, v, d, level + 1);
        }
        return root;
    }
}
