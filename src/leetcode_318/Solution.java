package leetcode_318;

class Solution {
    public int maxProduct(String[] words) {
        int[] wordsInBit = new int[words.length];
        for (int i = 0; i < words.length; i++){
            for (int j = 0; j < words[i].length(); j++){
                wordsInBit[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int ans = 0;
        for (int i = 0; i < words.length - 1; i++){
            for (int j = i + 1; j < words.length; j++){
                if ( (wordsInBit[i] | wordsInBit[j]) == (wordsInBit[i] ^ wordsInBit[j]))
                    ans = Math.max(ans, words[i].length() * words[j].length());
            }
        }
        return ans;
    }
}
