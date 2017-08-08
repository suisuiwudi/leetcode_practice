package leetcode_52;

public class Solution {
    private int ans;
    public int totalNQueens(int n) {
        ans = 0;
        int[] process = new int[n];
        queue(n, 0, 0, 0, 0, 0);
        return ans;
    }
    public void queue(int n, int index, int verticalMask, int adjacentMask, int leftDigMask, int rightDigMask){
        if (index == n){
            ans++;
        } else {
            int place = 1;
            for (int i = 0 ; i < n; i++){
                if ((place << i & ~(verticalMask | adjacentMask | leftDigMask | rightDigMask)) > 0){
                    int nextAdjacentMask = place << i;
                    if (i < n - 1) nextAdjacentMask += place << (i + 1);
                    if (i > 0) nextAdjacentMask += place << (i - 1);
                    int nextLeftDigMask = (leftDigMask | (place << i)) << 1;
                    int nextRightDigMask = (rightDigMask | (place << i)) >> 1;
                    queue(n, index + 1, verticalMask | (place << i), nextAdjacentMask, nextLeftDigMask, nextRightDigMask);
                }
            }
        }
    }
}