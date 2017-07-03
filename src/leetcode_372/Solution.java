package leetcode_372;

public class Solution {
    private int mod = 1337;
    public int superPow(int a, int[] b) {
        return helpSuperPow(a % mod, b, b.length - 1);
    }
    public int helpSuperPow(int a, int[] b, int index){
        if (index < 0) return 1;
        return pow(helpSuperPow(a, b, index - 1) , 10) * pow(a,b[index]) % mod;
    }
    public int pow(int a, int b){
        int ans = 1;
        for (int i = 0; i < b; i++){
            ans = (ans * a) % mod;
        }
        return ans;
    }
}