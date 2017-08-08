package leetcode_51;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList();
        int[] process = new int[n];
        queue(ans,process, n, 0, 0, 0, 0, 0);
        return ans;
    }
    public void queue(List<List<String>> ans, int[] process, int n, int index, int verticalMask, int adjacentMask, int leftDigMask, int rightDigMask){
        if (index == n){
            getAns(ans, process);
        } else {
            int place = 1;
            for (int i = 0 ; i < n; i++){
                if ((place << i & ~(verticalMask | adjacentMask | leftDigMask | rightDigMask)) > 0){
                    process[index] = i;
                    int nextAdjacentMask = place << i;
                    if (i < n - 1) nextAdjacentMask += place << (i + 1);
                    if (i > 0) nextAdjacentMask += place << (i - 1);
                    int nextLeftDigMask = (leftDigMask | (place << i)) << 1;
                    int nextRightDigMask = (rightDigMask | (place << i)) >> 1;
                    queue(ans, process, n, index + 1, verticalMask | (place << i), nextAdjacentMask, nextLeftDigMask, nextRightDigMask);
                }
            }
        }
    }
    public void getAns(List<List<String>> ans, int[] process){
        List<String> tmp = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < process.length; i++){
            sb.append('.');
        }
        for (int i = 0; i < process.length; i++){
            StringBuilder tmpSB = new StringBuilder(sb);
            tmpSB.setCharAt(process[i],'Q');
            tmp.add(tmpSB.toString());
        }
        ans.add(tmp);
    }
}
