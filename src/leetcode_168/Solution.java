package leetcode_168;

class Solution {
    public String convertToTitle(int n) {
        int x = n;
        StringBuilder sb = new StringBuilder();
        while(x > 0){
            x--;
            sb.append((char) ((x % 26)+(int) 'A'));
            x = x / 26;
        }
        return sb.reverse().toString();
    }
}
