package leetcode_307;

public class NumArray {
    class SegmentTreeNode{
        int begin,end;
        int sum;
        SegmentTreeNode left,right;
        public SegmentTreeNode (int begin,int end){
            this.begin = begin;
            this.end = end;
            this.sum = 0;
            this.left = null;
            this.right = null;
        }
    }
    private SegmentTreeNode root = null;
    
    public NumArray(int[] nums) {
        root = build(nums, 0,nums.length-1);
    }
    public SegmentTreeNode build(int[] nums,int i,int j){
        if (i>j) {
            return null;
        }
        SegmentTreeNode set = new SegmentTreeNode(i,j);
        if (i==j) set.sum = nums[i];
        else{
            int mid = (i + j) / 2;
            set.left = build(nums,i,mid);
            set.right = build(nums,mid+1,j);
            set.sum = set.left.sum + set.right.sum;
        }
        return set;
    }
    public void update(int i, int val) {
        update(root,i,val);
    }
    public void update(SegmentTreeNode root,int i,int val){
        if (root == null) return;
        if (root.begin == root.end) {
            root.sum = val;
            return;
        }
        int mid = (root.begin + root.end) / 2;
        if (i <= mid){
            update(root.left,i,val);
        }else{
            update(root.right,i,val);
        }
        root.sum = root.left.sum + root.right.sum;
    }
    
    public int sumRange(int i, int j) {
        return sumRange(root,i,j);
    }
    public int sumRange(SegmentTreeNode root, int i, int j){
        if (root.begin>j || root.end<i) return 0;
        if (i == root.begin && j == root.end) return root.sum;
        int mid = (root.begin + root.end) / 2;
        if (mid<=j && mid >=i)
            return sumRange(root.left,i,mid)+sumRange(root.right,mid+1,j); 
        else
            return sumRange(root.left,i,j)+sumRange(root.right,i,j);
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */