package leetcode_71;

import java.util.*;
public class Solution {
    public String simplifyPath(String path) {
        String[] pathString = path.split("/");
        List<String> stack = new ArrayList<>();
        for (String s : pathString){
            if (s.equals("..")){
                if (!stack.isEmpty()){
                    stack.remove(stack.size()-1);
                }
            }
            else{
                if (!s.equals(".")&&!s.equals("")){
                    stack.add(s);
                }
            }
        }
        return "/" + String.join("/",stack);
    }
}