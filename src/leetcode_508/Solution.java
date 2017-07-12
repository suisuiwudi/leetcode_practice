package leetcode_508;

import java.util.HashMap;
import java.util.Map;

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
    private HashMap<Integer, Integer> map;
    private int maxFre, num;
    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap();
        subTreeSum(root);
        int[] ans = new int[num];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value == maxFre){
                ans[i++] = key;    
            }
        }
        return ans;
    }
    public int subTreeSum(TreeNode root){
        if (root == null) return 0;
        int sum = subTreeSum(root.left) + subTreeSum(root.right) + root.val;
        map.put(sum, map.getOrDefault(sum,0) + 1);
        if (map.get(sum) > maxFre){
            maxFre = map.get(sum);
            num = 1;
        } else if (map.get(sum) == maxFre){
            num++;
        }
        return sum;
    }
}
