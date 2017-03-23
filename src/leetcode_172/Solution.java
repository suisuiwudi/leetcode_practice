package leetcode_172;

public class Solution {
    public int trailingZeroes(int n) {
        if (n == 0) return 0;
        return trailingZeroes(n / 5) + n / 5;
    }
}