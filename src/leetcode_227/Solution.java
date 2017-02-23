package leetcode_227;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int calculate(String s) {
        char sign = '+';
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        s = s+".";
        for (int i = 0; i < s.length(); i++){
            if (Character.isDigit(s.charAt(i))){
                num = num*10 + s.charAt(i) - '0';
            } else if (s.charAt(i)!=' '){
                if (sign == '+'){
                    stack.push(num);
                } else if (sign == '-'){
                    stack.push(-num);
                } else if (sign == '*'){
                    stack.push(stack.pop()*num);
                } else{
                    stack.push(stack.pop()/num);
                }
                num = 0;
                sign = s.charAt(i);
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) ans += stack.pop();
        return ans;
     }
}