package leetcode_455;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int p = 0;
        for (int i = 0; i < g.length; i++){
            while (p < s.length && s[p] < g[i]) p++;
            if (p < s.length) ans++;
            p++;
        }
        return ans;
    }
}