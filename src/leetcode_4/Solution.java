package leetcode_4;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k = (nums1.length+nums2.length + 1) / 2;
        int nums1Start = 0;
        int nums2Start = 0;
        int getKth = 0;
        int n = 0;
        int m = 0;
        while (k > 0){
            n = nums1.length - nums1Start;
            m = nums2.length - nums2Start; 
            if (n == 0){
                getKth = nums2[nums2Start + k - 1];
                break;
            }
            if (m == 0){
                getKth = nums1[nums1Start + k - 1];
                break;
            }
            if (k == 1){
                getKth = Math.min(nums1[nums1Start],nums2[nums2Start]);
                break;
            }
            int i = Math.min(n, k / 2);
            int j = Math.min(m, k / 2);
            if (nums1[i + nums1Start - 1] < nums2[j + nums2Start - 1]){
                nums1Start += i;
                k -= i;
            } else {
                nums2Start += j;
                k -= j;
            }
        }
        if ((nums1.length+nums2.length) % 2 == 1) return (double) getKth;
        else {
            if (n == 0)
                return (nums2[nums2Start + k - 1] + nums2[nums2Start + k]) / 2.0;
            else if (m == 0)
                return (nums1[nums1Start + k - 1] + nums1[nums1Start + k]) / 2.0;
            else {
                double num1 = Double.MAX_VALUE;
                double num2 = (nums1[nums1Start]+nums2[nums2Start]) / 2.0;
                double num3 = Double.MAX_VALUE;
                if (nums1Start + 1 < nums1.length){
                    num1 = (nums1[nums1Start] + nums1[nums1Start + 1]) / 2.0;
                }
                if (nums2Start + 1 < nums2.length){
                    num3 = (nums2[nums2Start] + nums2[nums2Start + 1]) / 2.0;
                }
                return Math.min(num1,Math.min(num2,num3));
            }
        }
    }
}