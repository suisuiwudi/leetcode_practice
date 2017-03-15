package leetcode_202;

public class Solution {
    public boolean isHappy(int n) {
        int ans = n;
        int times = 0;
        while (ans != 1 && times < 50){
            int tmp = ans;
            ans = 0;
            while ( tmp!=0 ){
                ans += (tmp%10)*(tmp%10);
                tmp /= 10;
            }
            times++;
        }
        return ans == 1;
    }
}
