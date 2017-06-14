package leetcode_118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList();
        for (int i = 0; i < numRows; i++){
            List<Integer> tmp = new ArrayList();
            tmp.add(1);
            for (int j = 1; j < i; j++){
                tmp.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
            }
            if (i > 0) tmp.add(1);
            ans.add(tmp);
        }
        return ans;
    }
}