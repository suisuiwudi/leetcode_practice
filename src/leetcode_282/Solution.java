package leetcode_282;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> ans;
    public List<String> addOperators(String num, int target) {
        ans = new ArrayList();
        if (num == null || num.length() == 0) return ans;
        dfs("", num, target, 0, 0, 0);
        return ans;
    }
    public void dfs(String path, String num, int target, int index, long eval, long multed){
        if (index == num.length()){
            if (target == eval)
                ans.add(path);
            return;
        }
        for (int i = index; i < num.length(); i++){
            if (i != index && num.charAt(index) == '0') break;
            long cur = Long.parseLong(num.substring(index, i + 1));
            if (index == 0){
                dfs(path + cur, num, target, i + 1, cur, cur);
            } else {
                dfs(path + "+" + cur, num, target, i + 1, eval+cur, cur);
                dfs(path + "-" + cur, num, target, i + 1, eval-cur, -cur);
                dfs(path + "*" + cur, num, target, i + 1, eval- multed + multed*cur, cur*multed);
            }
        }
    }
}