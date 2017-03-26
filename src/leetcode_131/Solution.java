package leetcode_131;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>>[] opt = new LinkedList[n];
        for (int i = 0; i < n; i++){
            opt[i] = new LinkedList();
            String tmp = s.substring(0,i+1);
            if (isPalindrome(tmp)) {
                List<String> newList = new LinkedList();
                newList.add(tmp);
                opt[i].add(newList);
            }
            for (int j = 0; j < i; j++){
                tmp = s.substring(j+1,i+1);
                if (isPalindrome(tmp)){
                    List<String> newList = new LinkedList();
                    for (List oldList : opt[j]){
                        newList = new LinkedList(oldList);
                        newList.add(tmp);
                        opt[i].add(newList);
                    }
                }
            }
        }
        return opt[n-1];
    }
    public boolean isPalindrome(String s){
        int n = s.length();
        for (int i = 0; i < s.length() / 2; i++){
            if (s.charAt(i) != s.charAt(n-i-1)){ 
                return false;
            }
        }
        return true;
    }
}