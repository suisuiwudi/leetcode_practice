package leetcode_87;

public class Solution {
    
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        int n = s1.length();
        int[] counts = new int[26];
        for (int i = 0; i < n; i++){
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++){
            if (counts[i] != 0) return false;
        }
        
        for (int i = 1; i < n; i++){
            if (isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i))){
                return true;
            }
            if (isScramble(s1.substring(0,i),s2.substring(n - i)) && isScramble(s1.substring(i),s2.substring(0,n - i))){
                return true;
            }
        }
        return false;
    }
}