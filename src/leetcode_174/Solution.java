package leetcode_174;

import java.util.Arrays;

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] opt = new int[n][m];
         for (int[] row : opt)
             Arrays.fill(row,Integer.MAX_VALUE);
        opt[n-1][m-1] = Math.max(1, 1-dungeon[n-1][m-1]);
        for (int i = n-1; i >= 0 ; i--)
            for (int j = m-1; j >= 0; j--)
            if (!(i == n-1 && j == m-1)){
                if (i == n-1) opt[i][j] = Math.max(opt[i][j+1]-dungeon[i][j],1);
                else if (j == m-1) opt[i][j] = Math.max(opt[i+1][j]-dungeon[i][j],1);
                else
                    opt[i][j] = Math.max(Math.min(opt[i+1][j],opt[i][j+1])-dungeon[i][j],1);
                
            }
        return opt[0][0];
    }
}