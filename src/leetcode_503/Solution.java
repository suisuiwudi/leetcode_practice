package leetcode_503;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] newArray = new int[nums.length*2];
        for (int i = 0; i < newArray.length ; i++){
            newArray[i] = nums[i % nums.length];
        }
        int[] ans = new int[nums.length];
        for (int i = 0 ; i < nums.length ; i++){
            int index = i + 1;
            while (index < newArray.length && newArray[index] <= nums[i]){
                index++;
            }
            if (index == newArray.length){
                ans[i] = -1;
            } else{
                ans[i] = newArray[index];
            }
        }
        return ans;
    }
}