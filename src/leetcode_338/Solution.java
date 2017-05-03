package leetcode_338;

public class Solution {
    public int[] countBits(int num) {
        int[] opt = new int[num + 1];
        opt[0] = 0;
        int pow = 1;
        for (int i = 1; i < num + 1; i++){
            if (i >= pow * 2){
                pow *= 2;
            }
            opt[i] = opt[i - pow] + 1;
        }
        return opt;
    }
}