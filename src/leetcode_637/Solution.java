package leetcode_637;

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
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> totValue = new ArrayList();
        List<Integer> total = new ArrayList();
        traversal(root,0,totValue,total);
        List<Double> ans = new ArrayList();
        for (int i = 0; i < totValue.size(); i++){
            ans.add(totValue.get(i) / total.get(i));
        }
        return ans;
    }
    public void traversal(TreeNode root, int level, List<Double> totValue, List<Integer> total){
        if (root == null) return;
        if (level < totValue.size()) {
            totValue.set(level, totValue.get(level) + root.val);
            total.set(level, total.get(level) + 1);
        } else {
            totValue.add((double)root.val);
            total.add(1);
        }
        traversal(root.left, level + 1, totValue, total);
        traversal(root.right, level + 1, totValue, total);
    }
}