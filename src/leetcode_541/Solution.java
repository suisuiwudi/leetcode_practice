package leetcode_541;

public class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        int i = 0;
        boolean flag = true;
        while ( i < s.length()){
            if (i+k < s.length()) sb = new StringBuilder(s.substring(i,i+k));
            else sb = new StringBuilder(s.substring(i));
            if (flag) ans.append(sb.reverse());
            else ans.append(sb);
            flag = !flag;
            i += k;
        }
        return ans.toString();
    }
}