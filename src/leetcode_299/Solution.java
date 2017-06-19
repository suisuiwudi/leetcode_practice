package leetcode_299;

public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] notYetGuess = new int[10];
        for (int i = 0; i < secret.length(); i++){
            if (secret.charAt(i) == guess.charAt(i)){
                bulls++;
            } else{
                notYetGuess[secret.charAt(i) - '0']++;
                if (notYetGuess[secret.charAt(i) - '0'] <= 0) cows++;
                notYetGuess[guess.charAt(i) - '0']--;
                if (notYetGuess[guess.charAt(i) - '0'] >= 0) cows++;
            }
        }
        return bulls+"A"+cows+"B";
    }
}