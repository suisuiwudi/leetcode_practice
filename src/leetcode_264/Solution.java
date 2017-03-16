package leetcode_264;

import java.util.Arrays;

public class Solution {
    public int nthUglyNumber(int n) {
        int[] factors = {2,3,5};
        int[] num = new int[3];
        int[] f = new int[n];
        f[0] = 1;
        Arrays.fill(num,0);
        for (int i = 1; i < n; i++){
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < 3; k++){
                if (f[num[k]]*factors[k] < min){
                    min = f[num[k]]*factors[k];
                }
            }
            f[i] = min;
            for (int k = 0; k < 3; k++){
                if (f[num[k]]*factors[k] == min){
                    num[k]++;
                }
            }
        }
        return f[n-1];
    }
}