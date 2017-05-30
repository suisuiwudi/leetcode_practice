package leetcode_274;

public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0;
        int high = n;
        while (low<=high){
            int mid = (low + high) / 2;
            int p = 0;
            for (int i = 0; i < n; i++){
                if (citations[i] >= mid) p++;
            }
            if (p < mid) high = mid - 1;
            else low = mid + 1;
        }
        return high;
    }
}