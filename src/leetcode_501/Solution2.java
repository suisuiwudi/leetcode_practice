package leetcode_501;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution2 {
    Set<Integer> ans;
    int maxFre;
    int preValue;
    int count;
    public int[] findMode(TreeNode root) {
        ans = new HashSet();
        maxFre = 0;
        count = 0;
        preValue = -1;
        traversal(root);
        int[] ansArr = new int[ans.size()];
        int i = 0;
        for (int val : ans){
            ansArr[i++] = val;
        }
        return ansArr;
    }
    public void traversal(TreeNode root){
        if (root == null){
            return;
        }
        traversal(root.left);
        if (preValue == root.val){
            count++;
        } else {
            count = 1;
        }
        if (count > maxFre){
            ans.clear();
            maxFre = count;
            ans.add(root.val);
        } else if (count == maxFre){
            ans.add(root.val);
        }
        preValue = root.val;
        traversal(root.right);
    }
}