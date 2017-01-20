package leetcode_230;

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
    public int kthSmallest(TreeNode root, int k) {
     
        int left_sum = sum(root.left);
        if (left_sum + 1 == k) return root.val;
        else if (k > left_sum +1 ) return kthSmallest(root.right,k-left_sum-1);
        else return kthSmallest(root.left,k);
    }
    public int sum(TreeNode root){
        if (root == null) return 0;
        return sum(root.left)+sum(root.right)+1;
    }
}