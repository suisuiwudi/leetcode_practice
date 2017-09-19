package leetcode_119;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        LinkedList<Integer> ans = new LinkedList();
        ans.add(1);
        for (int i = 0; i < rowIndex; i++){
            for (int j = 0; j < i ; j++){
                ans.add(ans.pollFirst()+ans.getFirst());
            }
            ans.add(1);
        }
        return ans;
    }
}
