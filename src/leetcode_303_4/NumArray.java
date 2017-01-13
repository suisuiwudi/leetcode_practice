package leetcode_303_4;

public class NumArray {
	private int add[];
	public NumArray(int[] nums){
		for ( int i = 1; i<nums.length; i++)
			nums[i]=nums[i-1]+nums[i];
		this.add = nums;
	}
	public int sumRange(int i, int j){
		if (i>0) return add[j]-add[i-1];
		return add[j];
	}
}
