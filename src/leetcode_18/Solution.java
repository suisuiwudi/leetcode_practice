package leetcode_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet();
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                for (int second = j + 1, third = nums.length - 1; second < third; second++){
                    if (second > j + 1 && nums[second] == nums[second - 1]) continue;
                    int left = second + 1;
                    int right = third;
                    
                    while (left <= right){
                        int mid = (left + right) / 2;
                        if (nums[i] + nums[j]+ nums[second] + nums[mid] > target){
                            right = mid - 1;
                        } else if (nums[i] + nums[j] + nums[second] + nums[mid] < target){
                            left = mid + 1;
                        } else {
                            List<Integer> newList = new ArrayList();
                            newList.add(nums[i]);
                            newList.add(nums[j]);
                            newList.add(nums[second]);
                            newList.add(nums[mid]);
                            ans.add(newList);
                            break;
                        }
                    }
                    third = right;
                }  
            }
        }
        return new ArrayList(ans);
    }
}