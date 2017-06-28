package leetcode_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
	    public List<List<Integer>> threeSum(int[] nums) {
	        Arrays.sort(nums);
	        List<List<Integer>> ans = new ArrayList();
	        for (int i = 0; i < nums.length - 2; i++){
	            if (i > 0 && nums[i] == nums[i - 1]) continue;
	                int left = i + 1;
	                int right = nums.length - 1;
	                
	                while (left < right && left > i){
	                    if (nums[i] + nums[left] + nums[right] > 0){
	                        right--;
	                    } else if (nums[i] + nums[left] + nums[right] < 0){
	                        left++;
	                    } else {
	                        List<Integer> newList = new ArrayList();
	                        newList.add(nums[i]);
	                        newList.add(nums[left]);
	                        newList.add(nums[right]);
	                        ans.add(newList);
	                        while (left + 1 < right && nums[left+1] == nums[left]) left++;
	                        while (left + 1 < right && nums[right-1] == nums[right]) right--;
	                        left++;right--;
	                    }
	                }
	        }
	        return ans;
	    }
}
