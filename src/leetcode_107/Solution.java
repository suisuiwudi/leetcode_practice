package leetcode_107;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        searchNode(root,0,ans);
        Collections.reverse(ans);
        return ans;
    }
    public void searchNode(TreeNode root, int level, List<List<Integer>> ans){
        if (root == null) return;
        
        if (ans.size() != level){
            ans.get(level).add(root.val);
        } else {
            List<Integer> newList = new LinkedList();
            newList.add(root.val);
            ans.add(newList);
        }
        
        if (root.left != null) searchNode(root.left, level+1, ans);
        if (root.right != null) searchNode(root.right, level+1, ans);

    }
}