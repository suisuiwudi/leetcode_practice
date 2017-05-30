package leetcode_274;

public class Solution2 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0) return 0;
        int[] bucket = new int[n+1];
        for (int i = 0; i < n; i++){
            if (citations[i] > n) bucket[n]++;
            else bucket[citations[i]]++;
        }
        int sum = 0;
        for (int i = n; i > 0; i--){
            sum += bucket[i];
            if (sum >= i) return i;
        }
        return 0;
    }
}