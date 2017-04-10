package leetcode_524;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>(){
            public int compare (String o1, String o2){
                if (o1.length() != o2.length()){
                    return o2.length() - o1.length();
                } else{
                    return o1.compareTo(o2);
                }
            }
            });
        for (String str : d){
            if (isSub(str,s)) return str;
        }
        return "";
    }
    public boolean isSub(String s1, String s2){
        int i = 0; 
        int j = 0;
        while (i < s1.length() && j < s2.length()){
            if (s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            } else{
                j++;
            }
        }
        return i == s1.length();
    }
}
