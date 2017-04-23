package leetcode_515;

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList();
        search(root,0,ans);
        return ans;
    }
    public void search(TreeNode root, int index, List<Integer> ans){
        if (root == null) return;
        if (index == ans.size()){
            ans.add(root.val);
        }
        if (root.val > ans.get(index)){
            ans.set(index,root.val);
        }
        search(root.right,index+1,ans);
        search(root.left,index+1,ans);
    }
}