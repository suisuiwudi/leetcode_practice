package leetcode_7;

public class Solution {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0){
            int newAns = ans * 10 + x % 10;
            if (newAns % 10 != x % 10){
                return 0;
            }
            x /= 10;
            ans = newAns;
        }
        return ans;
    }
}