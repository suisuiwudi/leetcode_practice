package leetcode_336;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Set<List<Integer>> ans = new HashSet();
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < words.length; i++){
            map.put(words[i], i);
        }
        if (words == null || words.length < 2) return new ArrayList();
        for (int i = 0; i < words.length; i++){
            for (int j = 0; j <= words[i].length(); j++){
                String preS = words[i].substring(0, j);
                String sufS = words[i].substring(j);
                
                
                if (isPalindrome(preS)){
                    String sufR = new StringBuilder(sufS).reverse().toString();
                    if (map.containsKey(sufR) && map.get(sufR) != i){
                        List<Integer> list = new ArrayList();
                        list.add(map.get(sufR));
                        list.add(i);
                        ans.add(list);
                    }
                }
                if (isPalindrome(sufS)){
                    String preR = new StringBuilder(preS).reverse().toString();
                    if (map.containsKey(preR) && map.get(preR) != i){
                        List<Integer> list = new ArrayList();
                        list.add(i);
                        list.add(map.get(preR));
                        ans.add(list);
                    }
                }
            }
        }
        return new ArrayList(ans);
    }
    public boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while (l <= r){
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}