package leetcode_373;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		Comparator<int[]> cmp = new Comparator<int[]>() { 
			public int compare(int[] e1, int[] e2) {
				return e1[0] + e1[1] - e2[0] - e2[1];
			}
		};
        PriorityQueue<int[]> heap = new PriorityQueue<>(k,cmp);
        for (int i = 0; i < nums1.length; i++)
            for (int j = 0; j < nums2.length; j++){
                int[] tmp = new int[2];
                tmp[0] = nums1[i];
                tmp[1] = nums2[j];
                heap.add(tmp);
            }
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < k && !heap.isEmpty(); i++){
            ans.add(heap.poll());
        }
        return ans;
    }
}