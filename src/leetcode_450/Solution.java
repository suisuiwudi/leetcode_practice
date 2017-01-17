package leetcode_450;

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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key > root.val) root.right = deleteNode(root.right, key);
        else if(key < root.val) root.left = deleteNode(root.left, key);
        else if(root.left == null) root = root.right;
        else if(root.right == null) root = root.left;
        else{
            root.val = findLeft(root.right);
            root.right = deleteNode(root.right,root.val);
        }
        return root;
    }
    
    public int findLeft(TreeNode root){
        if (root.left == null) return root.val;else return findLeft(root.left);
    }
}