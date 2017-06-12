package leetcode_95;
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList();
        return generateTree(1,n);
    }
    public List<TreeNode> generateTree(int start, int end){
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (start > end){
            ans.add(null);
            return ans;
        }
        
        for (int i = start; i <=end; i++){
            List<TreeNode> leftTrees = generateTree(start, i - 1);
            List<TreeNode> rightTrees = generateTree(i + 1, end);
            for (TreeNode leftTree : leftTrees){
                for (TreeNode rightTree : rightTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}