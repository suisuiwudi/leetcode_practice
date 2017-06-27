package leetcode_598;

public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int row = m;
        int column = n;
        for (int[] op : ops){
            row = Math.min(row, op[0]);
            column = Math.min(column, op[1]);
        }
        return row * column;
    }
}
