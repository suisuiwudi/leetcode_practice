package leetcode_242;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {
		Map<Character, Integer> charCountMap = new LinkedHashMap();
		for (int i = 0; i < s.length(); i++){
				if (charCountMap.containsKey(s.charAt(i))){
					charCountMap.put(s.charAt(i), charCountMap.get(s.charAt(i)) + 1); 
				} else{
					charCountMap.put(s.charAt(i), 1); 
				}
			}
		
		for (int i = 0; i < t.length(); i++){
				if (charCountMap.containsKey(t.charAt(i))){
					charCountMap.put(t.charAt(i), charCountMap.get(t.charAt(i)) - 1); 
				} else{
					return false; 
				}
			}
		
		Iterator iter = charCountMap.entrySet().iterator();
		while (iter.hasNext()){
			Map.Entry entry = (Map.Entry) iter.next();
			if ( (int) entry.getValue() != 0 ) return false;
		}
		return true;
    }
}