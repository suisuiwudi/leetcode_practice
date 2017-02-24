package leetcode_91;

public class Solution {
    public int numDecodings(String s) {
        int pre2Char = 1;
        int pre1Char = 1;
        int now = 0;
        for (int i = 0; i < s.length(); i++){
            now = 0;
            if (isCharacter(s.substring(i,i+1))) now += pre1Char;
            if ( i > 0 && isCharacter(s.substring(i-1,i+1))) now += pre2Char;
            pre2Char = pre1Char;
            pre1Char = now;
        }
        return now;
        
    }
    public boolean isCharacter(String s){
        int  n = 0;
        if (s.charAt(0) == '0') return false;
        for (int i = 0 ; i < s.length();i++){
            n = n*10 + s.charAt(i) - '0';
        }
        if (n >0 && n <=26) return true;
        return false;
    }
}