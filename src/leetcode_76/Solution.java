package leetcode_76;

class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[256];
        for (int i = 0; i < t.length(); i++){
            map[t.charAt(i)]++;
        }
        int needToFill = t.length();
        int head = 0;
        int ansHead = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++){
            if (map[s.charAt(i)]-- > 0) needToFill--;
            while (needToFill == 0){
                if (i - head + 1 < ans){
                    ans = i - head + 1;
                    ansHead = head;
                }
                if (map[s.charAt(head++)]++ == 0){
                    needToFill++;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? "" : s.substring(ansHead, ansHead + ans); 
        
    }
}
