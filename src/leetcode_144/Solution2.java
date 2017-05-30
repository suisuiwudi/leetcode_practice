package leetcode_144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList();
        List<Integer> ans = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode top = stack.pop();
            ans.add(top.val);
            if (top.right != null) stack.push(top.right);
            if (top.left != null) stack.push(top.left);
        }
        return ans;
    }
}