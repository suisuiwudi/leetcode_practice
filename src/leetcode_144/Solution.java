package leetcode_144;

import java.util.ArrayList;
import java.util.List;

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
    private List<Integer> ans;
    public List<Integer> preorderTraversal(TreeNode root) {
        ans = new ArrayList();
        helper(root);
        return ans;
    }
    public void helper(TreeNode root){
        if (root == null) return;
        ans.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}
