package leetcode_263;

public class Solution {
    public boolean isUgly(int num) {
        int tmp = num;
        if (num < 1) return false;
        while (tmp % 2 == 0) tmp >>= 1;
        while (tmp % 3 == 0) tmp /= 3;
        while (tmp % 5 == 0) tmp /= 5;
        if (tmp == 1) return true;
        else return false;
    }
}