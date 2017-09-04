package leetcode_229;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        int candidate1 = -1;
        int candidate2 = -2;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == candidate1){
                count1++;
            } else if (nums[i] == candidate2){
                count2++;
            } else if (count1 == 0){
                candidate1 = nums[i];
                count1 = 1;
            } else if (count2 == 0){
                candidate2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == candidate1) count1++;
            if (nums[i] == candidate2) count2++;
        }
        List<Integer> ans = new ArrayList();
        if (count1 > nums.length / 3){
            ans.add(candidate1);
        }
        if (count2 > nums.length / 3){
            ans.add(candidate2);
        }
        return ans;
    }
}
