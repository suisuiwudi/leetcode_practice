package leetcode_106;

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeNode(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    public TreeNode buildTreeNode(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight){
        if (inRight < inLeft || postRight < postLeft) return null;
        int rootVal = postorder[postRight];
        int leftLength = 0;
        int rightLength = 0;
        TreeNode root = new TreeNode(rootVal);
        for (int i = inLeft; i <= inRight; i++){
            if (inorder[i] == rootVal){
                leftLength = i - inLeft;
                rightLength = inRight - i;
                break;
            }
        }
        
        if (leftLength > 0)
        root.left = buildTreeNode(inorder,postorder,inLeft,inLeft + leftLength - 1, postLeft, postLeft+ leftLength - 1 );
        if (rightLength > 0)
        root.right = buildTreeNode(inorder,postorder, inRight - rightLength + 1, inRight, postRight - rightLength , postRight - 1);
        return root;
    }
}