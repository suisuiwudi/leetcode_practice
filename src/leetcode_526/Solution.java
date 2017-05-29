package leetcode_526;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private int ans;
    public int countArrangement(int N) {
        Set<Integer> arrange = new HashSet();
        helper(N, 1, arrange);
        return ans;
    }
    public void helper(int n, int index, Set<Integer> arrange){
        if (index == n + 1){
            ans++;
        }
        for (int i = 1; i <= n; i++){
            if (!arrange.contains(i) && (i % index == 0 || index % i == 0)){
                arrange.add(i);
                helper(n, index + 1, arrange);
                arrange.remove(i);
            }
        }
    }
}