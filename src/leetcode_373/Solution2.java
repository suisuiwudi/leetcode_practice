package leetcode_373;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution2 {
    public class Item{
        int index1;
        int index2;
        int sum;
        Item(int index1, int index2, int sum){
            this.index1 = index1;
            this.index2 = index2;
            this.sum = sum;
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Item> PQ = new PriorityQueue<Item>(new Comparator<Item>(){
            public int compare(Item o1, Item o2){
                return o1.sum - o2.sum;
            }
        });
        if (nums2.length > 0){
            for (int i = 0; i < nums1.length; i++){
                PQ.add(new Item(i,0,nums1[i]+nums2[0]));
            }
        }
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < k && !PQ.isEmpty(); i++){
            Item item = PQ.poll();
            ans.add(new int[]{nums1[item.index1], nums2[item.index2]});
            if (item.index2 < nums2.length - 1)
                PQ.add(new Item(item.index1, item.index2+1, nums1[item.index1]+nums2[item.index2+1]));
        }
        return ans;
    }
}