package leetcode_337;

import java.util.HashMap;

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
    public int rob(TreeNode root) {
        int[] ans = new int[2];
        ans = bestRob(root);
        return Math.max(ans[0],ans[1]);
    }
    public int[] bestRob(TreeNode root){
        int[] ans = new int[2];
        if (root == null) return ans;
        int[] left = bestRob(root.left);
        int[] right = bestRob(root.right);
        ans[1] = left[0]+right[0]+root.val;
        ans[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return ans;
        
    }
}