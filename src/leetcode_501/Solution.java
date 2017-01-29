package leetcode_501;

import java.util.HashMap;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	private int[] ans;
	private HashMap<Integer, Integer> nummap;

	public int[] findMode(TreeNode root) {
		ans = new int[10000];
		nummap = new HashMap<Integer, Integer>();
		find(root);
		int max = 0;
		int num = 0;
		for (HashMap.Entry<Integer, Integer> i : nummap.entrySet())
			if (ans[i.getValue()] > max) {
				num = 1;
				max = ans[i.getValue()];
			} else if (ans[i.getValue()] == max) {
				num++;
			}
		int[] f = new int[num];
		int aa = 0;
		for (HashMap.Entry<Integer, Integer> i : nummap.entrySet())
			if (ans[i.getValue()] == max)
				f[aa++] = i.getKey();
		return f;
	}

	public void find(TreeNode root) {
		if (root == null)
			return;
		if (nummap.containsKey(root.val))
			ans[nummap.get(root.val)]++;
		else {
			nummap.put(root.val, nummap.size());
			ans[nummap.get(root.val)]++;
		}
		find(root.left);
		find(root.right);
	}
}