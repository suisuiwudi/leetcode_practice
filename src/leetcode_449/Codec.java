package leetcode_449;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        String l = serialize(root.left);
        String r = serialize(root.right);
        if (l == null && r == null )
        return "" + (char)root.val;
        else if (l == null)
        return (char)root.val + r;
        else if (r == null)
        return (char)root.val + l;
        else
        return  (char)root.val + l + r;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        if (data == null || data.length() == 0) return null;
        TreeNode tmp = new TreeNode((int)data.charAt(0));
        int i=0;
        for (; i < data.length() ; i++)
            if (data.charAt(i) > tmp.val) break;
        tmp.left = deserialize(data.substring (1,i));
        tmp.right = deserialize(data.substring (i));
        return tmp;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));