package leetcode_9;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x!=0 && x%10 == 0)) return false;
        if (x == 0) return true;
        int p = 0;
        while (x != 0){
            if (p*10 + x % 10 == x || p == x) return true;
            p = p*10 + x%10;
            x/=10;
        }
        return false;
    }
}