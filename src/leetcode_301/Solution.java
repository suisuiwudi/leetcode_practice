package leetcode_301;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new LinkedList();
        Set<String> visited = new HashSet();
        Set<String> ans = new HashSet();
        queue.add(s);
        visited.add(s);
        int ansLength = 0;
        while (!queue.isEmpty()){
            String now = queue.poll();
            if (now.length() < ansLength){
                break;
            }
            if (checkIsValid(now)) {
                ans.add(now);
                ansLength = now.length();
            } else {
                for (int i = 0; i < now.length(); i++) 
                    if (now.charAt(i) == '(' || now.charAt(i) == ')'){
                    String getNew = now.substring(0,i)+now.substring(i+1);
                    if(!visited.contains(getNew)){
                        queue.add(getNew);
                        visited.add(getNew);
                    }
                }
            }
            
        }
        if (ans.size() == 0) ans.add("");
        return new ArrayList(ans);
    }
    public boolean checkIsValid(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                count++;
            } else if (s.charAt(i) == ')'){
                if (count == 0) return false;
                count--;
            }
        }
        if (count != 0) return false;
        return true;
    }
}