package leetcode_315;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    class Node{
        Node left;
        Node right;
        int val;
        int num;
        Node(int val, int pre){
            this.val = val;
            this.pre = pre;
            nodes = 1;
            num = 1;
        }
        int pre;
        int nodes;
    }
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) return new ArrayList();
        Node root = new Node(nums[nums.length-1] ,0);
        List<Integer> ans = new ArrayList();
        ans.add(0);
        for (int i = nums.length-2 ; i >=0; i--){
            ans.add(buildBST(root,nums[i],0).pre);
        }
        Collections.reverse(ans);
        return ans;
    }
    public Node buildBST(Node root, int val, int pre){
        if (root == null){
            return new Node(val, pre);
        }
        if (root.val == val) {
            root.nodes++;
            root.num++;
            int leftNodes = 0;
            if (root.left != null) leftNodes = root.left.nodes;
            root.pre = pre + leftNodes;
        } else if (root.val > val){
            int rightNodes = 0;
            if (root.right != null) rightNodes = root.right.nodes;
            root.left = buildBST(root.left, val, pre);
            root.nodes = root.left.nodes + rightNodes + root.num;
            root.pre = root.left.pre;
        } else {
            int leftNodes = 0;
            if (root.left != null) leftNodes = root.left.nodes;
            root.right = buildBST(root.right, val, pre + leftNodes + root.num);
            root.nodes = root.right.nodes + leftNodes + root.num;
            root.pre = root.right.pre;
        }
        return root;
   }
}