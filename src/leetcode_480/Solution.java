package leetcode_480;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    class Heap{
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;
        public Heap(){
            minHeap = new PriorityQueue();
            maxHeap = new PriorityQueue(new Comparator<Integer>(){
                public int compare(Integer o1, Integer o2){
                    return (int)((double) o2 - (double) o1);
                }
            });
        }
        public void add(int a){
            if (maxHeap.size() > 0 && a <= maxHeap.peek()){
                maxHeap.add(a);
            } else {
                minHeap.add(a);
            }
            keepBalance();
        }
        public void remove(int a){
            if (maxHeap.remove(a) || minHeap.remove(a)){
                keepBalance();
            }
        }
        public void keepBalance(){
            while (maxHeap.size() - 1 > minHeap.size()){
                minHeap.add(maxHeap.poll());
            }
            while (maxHeap.size() < minHeap.size()){
                maxHeap.add(minHeap.poll());
            }
        }
        public double median(){
            if (maxHeap.size() == minHeap.size()){
                return ((double)maxHeap.peek() + (double)minHeap.peek()) / 2;
            } else 
                return (double) maxHeap.peek();
        }
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        Heap heap = new Heap();
        double[] ans = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++){
            heap.add(nums[i]);
        }
        ans[0] = heap.median();
        for (int i = k; i < nums.length; i++){
            heap.add(nums[i]);
            heap.remove(nums[i-k]);
            ans[i-k+1] = heap.median();
        }
        return ans;
    }
}
