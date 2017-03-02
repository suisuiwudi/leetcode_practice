package leetcode_150;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String tmp : tokens){
                if (tmp.equals("+")){
                    stack.push(stack.poll()+stack.poll());
                }else if (tmp.equals("-")){
                    int a = stack.poll();
                    stack.push(stack.poll()-a);
                } else if (tmp.equals("*")){
                    stack.push(stack.poll()*stack.poll());
                } else if (tmp.equals("/")){
                    int a = stack.poll();
                    stack.push(stack.poll()/a);
                }else{
                    stack.push(Integer.parseInt(tmp));
                }
            }
    
        return stack.poll();
    }
}
