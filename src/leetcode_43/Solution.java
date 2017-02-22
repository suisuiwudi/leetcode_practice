package leetcode_43;

public class Solution {
    public String multiply(String num1, String num2) {
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int[] ans =  new int[char1.length+char2.length];
        int n = ans.length;
        for (int i = char1.length - 1; i >=0; i--){
            for (int j = char2.length- 1; j>=0; j--){
                int a = (int) (char1[i] - '0');
                int b = (int) (char2[j] - '0');
                ans[i+j+1] += a*b;
                ans[i+j] += ans[i+j+1]/10;
                ans[i+j+1] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < n; i++)
            if (i!=0 || ans[i]!=0) 
                sb.append(ans[i]);
        if (sb.charAt(0) == '0') return "0";
        else
        return sb.toString();
    }
}