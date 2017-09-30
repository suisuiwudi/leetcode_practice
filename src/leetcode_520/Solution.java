package leetcode_520;

class Solution {
    public boolean detectCapitalUse(String word) {
        return word.equals(word.toLowerCase()) || word.equals(word.toUpperCase()) || checkFirstCapital(word);
    }
    public boolean checkFirstCapital(String word){
        if (word.charAt(0) > 'Z' || word.charAt(0) < 'A') return false;
        for (int i = 1; i < word.length(); i++){
            if (word.charAt(i) > 'z' || word.charAt(i) < 'a') return false;
        }
        return true;
    }
}
