package leetcode_438;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] count = new int[26];
        int totCount = 0;
        int pLen = p.length();
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < p.length(); i++){
            count[p.charAt(i) - 'a']++;
            totCount++;
        }
        for (int i = 0; i < s.length(); i++){
            if (count[s.charAt(i) - 'a']-- > 0) 
                totCount--;
            if (i >= pLen) {
                if (count[s.charAt(i - pLen) - 'a']++ >= 0)
                    totCount++;
            }
            if (totCount == 0){
                ans.add(i - pLen + 1);
            }
        }
        return ans;
    }
}
