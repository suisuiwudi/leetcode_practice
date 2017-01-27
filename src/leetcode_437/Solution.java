package leetcode_437;


// Definition for a binary tree node.
//  public class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//  }
// 
public class Solution {
    private int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        pathRootEqualSum(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return count;
    }
    public void pathRootEqualSum(TreeNode root, int sum){
        if (root == null) return;
        if (sum == root.val) count++;
        pathRootEqualSum(root.left,sum - root.val);
        pathRootEqualSum(root.right,sum - root.val);
        
    }
}