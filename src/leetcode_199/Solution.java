package leetcode_199;

import java.util.List;
import java.util.ArrayList;
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        return rightView(root,0,ans);
    }
    public List<Integer> rightView(TreeNode root,int level, List<Integer> ans){
        if (root == null) return ans;
        if ( ans.size() == level ) 
            ans.add(root.val);
        ans = rightView(root.right,level+1,ans);
        return rightView(root.left,level+1,ans);
    }
}