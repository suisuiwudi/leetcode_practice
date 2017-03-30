package leetcode_452;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n == 0) return 0;
        int m = points[0].length;
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
            });
        int p = 0;
        int ans = 0;
        for (int i = 0; i < n; i = p){
            int set = points[i][1];
            while ( p < n && points[p][0]<=set){
                p++;
            }
            ans++;
        }
        return ans;
    }
}