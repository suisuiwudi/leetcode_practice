package leetcode_447;

import java.util.HashMap;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap();
        int ans = 0;
        for (int i = 0 ; i < points.length; i++){
            for (int j = 0; j < points.length; j++){
                if (i == j) continue;
                int dist = (points[i][0] - points[j][0])*(points[i][0] - points[j][0])+ (points[i][1] - points[j][1])*(points[i][1] - points[j][1]);
                map.put(dist, map.getOrDefault(dist,0) + 1);
            }
            for (int val : map.values()){
                ans += val * (val - 1);
            }
            map.clear();
        }
        return ans;
    }
}