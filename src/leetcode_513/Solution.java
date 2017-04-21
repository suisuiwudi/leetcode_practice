package leetcode_513;

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
    public int findBottomLeftValue(TreeNode root) {
        int[] ans = search(root,0);
        return ans[0];
    }
    public int[] search(TreeNode root, int index){
        if (root == null) return new int[]{-1,-1};
        
        int[] right = search(root.right, index + 1);
        int[] ans = {root.val, index};
        if (right[1] >= ans[1]) {
            ans[0] = right[0];
            ans[1] = right[1];
        }
        int[] left = search(root.left, index + 1);
        if (left[1] >= ans[1]) {
            ans[0] = left[0];
            ans[1] = left[1];
        }
        return ans;
    }
}