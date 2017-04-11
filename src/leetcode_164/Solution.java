package leetcode_164;

import java.util.Arrays;
public class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        int max = -Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            max = Math.max(nums[i],max);
            min = Math.min(nums[i],min);
        }
        int gap = (max-min)/(n - 1);
        if ((max-min) % (n - 1) > 0 ) gap++;
        int[] bucketMax = new int[n-1];
        int[] bucketMin = new int[n-1];
        boolean[] hasNumber = new boolean[n-1];
        Arrays.fill(hasNumber, false);
        Arrays.fill(bucketMax,-Integer.MAX_VALUE);
        Arrays.fill(bucketMin,Integer.MAX_VALUE);
        for (int i = 0 ; i < n ; i++)
        if (nums[i] != max && nums[i] != min){
            int k = (nums[i] - min) / gap;
            bucketMax[k] = Math.max(bucketMax[k], nums[i]);
            bucketMin[k] = Math.min(bucketMin[k], nums[i]);
            hasNumber[k] = true;
        }
        int pre = min;
        int now = min;
        int i = 0;
        while (i < n - 1){
            if (hasNumber[i]){
                now = bucketMin[i];
                gap = Math.max(gap, now - pre);
                pre = bucketMax[i];
            }
            i++;
        }

        gap = Math.max(gap, max - pre);
        return gap;
    }
}