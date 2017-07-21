package leetcode_42;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList();
        int ans = 0;
        for (int i = 0; i < height.length; i++){
            int lastPop;
            /*       *
                *3333*
                **222*
                ***1**
                ***1**
            
                *3333   //if stack is not empty this line should be removed from answer
                *3333*
                *3333*
                **222*
                ***1**
                ***1**
            */
            while (!stack.isEmpty() && height[i] >= height[stack.getLast()]){
                lastPop = stack.removeLast();
                if (stack.isEmpty()) break;
                ans += (i - stack.getLast() - 1) * (height[stack.getLast()] - height[lastPop]); 
            }
            if (!stack.isEmpty()){
                ans -= (i - stack.getLast() - 1) * (height[stack.getLast()] - height[i]);
            }
            stack.addLast(i);
        }
        return ans;
    }
}