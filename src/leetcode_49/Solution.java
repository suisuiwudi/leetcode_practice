package leetcode_49;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++){
            char[] Char = strs[i].toCharArray();
            Arrays.sort(Char);
            String sortedString = new String(Char);
            List<String> list = new ArrayList<>();
            if (map.containsKey(sortedString)){
                list = map.get(sortedString);
            } 
            list.add(strs[i]);
            map.put(sortedString,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}