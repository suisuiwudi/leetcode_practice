package leetcode_241;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private HashMap<String, List<Integer>> computed;
    public List<Integer> diffWaysToCompute(String input) {
        computed = new HashMap();
        return diffWays(input);
    }
    public List<Integer> diffWays(String input){
        if (computed.containsKey(input)) return computed.get(input);
        List<Integer> ans = new LinkedList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-' ||
                input.charAt(i) == '*' ||
                input.charAt(i) == '+' ) {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> part1Ret = diffWays(part1);
                List<Integer> part2Ret = diffWays(part2);
                for (Integer p1 :   part1Ret) {
                    for (Integer p2 :   part2Ret) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+': c = p1+p2;
                                break;
                            case '-': c = p1-p2;
                                break;
                            case '*': c = p1*p2;
                                break;
                        }
                        ans.add(c);
                    }
                }
            }
        }
        if (ans.size() == 0) {
            ans.add(Integer.valueOf(input));
        }
        computed.put(input,ans);
        return ans;
    }
}