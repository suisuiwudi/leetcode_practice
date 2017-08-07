package leetcode_354;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });
        int[] opt = new int[envelopes.length];
        int len = 0;
        for (int[] envelop : envelopes){
            int index = Arrays.binarySearch(opt,0,len,envelop[1]);
            if (index < 0){
                index = -index-1;
            }
            opt[index] = envelop[1];
            if (index == len){
                len++;
            }
        }
        return len;
    }
}
