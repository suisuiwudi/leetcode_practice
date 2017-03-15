package leetcode_224;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int calculate(String s) {
        int sign = 1;
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++){
            if (Character.isDigit(s.charAt(i))){
                int tmp = 0;
                while ( i < s.length() && Character.isDigit(s.charAt(i))){
                    tmp = tmp * 10 + s.charAt(i++) - '0';
                }
                i--;
                ans += sign * tmp;
            } else if (s.charAt(i) == '+'){
                sign = 1;
            } else if (s.charAt(i) == '-'){
                sign = -1;
            } else if (s.charAt(i) == '('){
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign = 1;
            } else if (s.charAt(i) == ')'){
                ans = ans * stack.pop() + stack.pop();
            }
        }
        return ans;
    }
}