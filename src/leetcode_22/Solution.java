package leetcode_22;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<String>();
        String s = "";
        dfs(s,0,0,n);
        return ans;
    }
    public void dfs(String s, int openParenthesesDone, int closeParenthesesDone, int n){
        if (openParenthesesDone == n && closeParenthesesDone == n){
            ans.add(s);
        }
        if (openParenthesesDone < n){
            dfs(s+"(",openParenthesesDone + 1,closeParenthesesDone, n);
        }
        if (closeParenthesesDone < openParenthesesDone ){
            dfs(s+")",openParenthesesDone,closeParenthesesDone + 1, n);
        }
    }
}