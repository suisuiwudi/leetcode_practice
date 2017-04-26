package leetcode_98;

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
    public boolean isValidBST(TreeNode root) {
        return minAndMax(root)[2] == 1;
    }
    public int[] minAndMax(TreeNode root){
        if (root == null) return new int[]{0,0,1};
        int[] tmp = new int[]{root.val,root.val,1};
        int[] left = new int[]{root.val,root.val,1};
        int[] right = new int[]{root.val,root.val,1};
        
        if (root.left != null){
            left = minAndMax(root.left);
        } 
        if (root.right != null){
            right = minAndMax(root.right);
        }
        
        if (left[2] == 0 || right[2] == 0 || (right[0] <= root.val && root.right!=null) || (left[1] >= root.val && root.left != null)) {
            tmp[2] = 0;
            return tmp;
        }
        tmp[0] = left[0];
        tmp[1] = right[1];
        return tmp;
    }
}