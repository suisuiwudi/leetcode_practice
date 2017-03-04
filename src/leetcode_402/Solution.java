package leetcode_402;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<>();
        int p = k;
        for (int i = 0; i < num.length(); i++ ){
            while ( p > 0 && !stack.isEmpty() && num.charAt(i) < stack.peek()){
                stack.pop();
                p--;
            }
            stack.push(num.charAt(i));
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty() && stack.peekLast() == '0'){
            stack.pollLast();
        }
        while (!stack.isEmpty() && p > 0){
            stack.poll();
            p--;
        }
        while (!stack.isEmpty()){
            ans.append(stack.pollLast());
        }
        if (ans.length() == 0) return "0";
        return ans.toString();
    }
}