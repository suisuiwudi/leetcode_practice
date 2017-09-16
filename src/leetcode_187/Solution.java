package leetcode_187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> words = new HashSet();
        Set<Integer> twiceWords = new HashSet();
        List<String> ans = new ArrayList();
        int[] map = new int[26];
        map['C'-'A'] = 1;
        map['G'-'A'] = 2;
        map['T'-'A'] = 3;
        int seqBit = 0;
        for (int i = 0; i < s.length(); i++){
            seqBit >>= 2;
            seqBit += map[s.charAt(i) - 'A'] << 18;
            if (i >= 9 && !words.add(seqBit) && twiceWords.add(seqBit)){
                ans.add(s.substring(i-9,i+1));
            }
        }
        return ans;
    }
}
