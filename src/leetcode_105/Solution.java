package leetcode_105;

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
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1, inorder, 0 , inorder.length-1);
    }
    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if (preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        for (int i = inStart; i <= inEnd; i++){
            if (inorder[i] == preorder[preStart]){
                root.left = build(preorder, preStart + 1, preStart + i - inStart, inorder, inStart, i - 1);
                root.right = build(preorder, preStart + i - inStart + 1, preEnd, inorder, i + 1, inEnd);
                return root;
            }
        }
        return null;
    }
}