package leetcode_32;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int longestValidParentheses(String s) {
        Deque<parentheses> stack = new LinkedList<>();
        stack.add(new parentheses(')',-1));
        int ans = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '('){
                stack.add(new parentheses(c,i));
            } else if (c == ')'){
                if (stack.peekLast().getC() == '('){
                    stack.removeLast();
                    ans = Math.max(i - stack.peekLast().getPos(), ans);
                } else{
                    stack.addLast(new parentheses(')',i));
                }
            }
        }
        return ans;
    }
    private class parentheses{
        private char c;
        private int pos;
        parentheses(char c, int pos){
            this.c = c;
            this.pos = pos;
        }
        public char getC(){
            return c;
        }
        public int getPos(){
            return pos;
        }
    }
}
