package leetcode_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        for (int i = 0; i < nums.length - 3; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                
                while (left < right){
                    if (nums[i] + nums[j] + nums[left] + nums[right] > target){
                        right--;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] < target){
                        left++;
                    } else {
                        List<Integer> newList = new ArrayList();
                        newList.add(nums[i]);
                        newList.add(nums[j]);
                        newList.add(nums[left]);
                        newList.add(nums[right]);
                        ans.add(newList);
                        while (left + 1 < right && nums[left+1] == nums[left]) left++;
                        while (left + 1 < right && nums[right-1] == nums[right]) right--;
                        left++;right--;
                    }
                }
            }
  
        }
        return ans;
    }
}