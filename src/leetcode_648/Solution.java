package leetcode_648;

import java.util.List;

class Solution {
    class TrieNode{
        char val;
        TrieNode[] children;
        boolean isWord;
        TrieNode(char val){
            this.val = val;
            children = new TrieNode[26];
            isWord = false;
        }
    }
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = buildTrie(dict);
        return replaceShortestWords(root, sentence.split(" "));
    }
    public String replaceShortestWords(TrieNode root, String[] words){
        StringBuilder sb = new StringBuilder();
        for (String str : words){
            TrieNode iterator = root;
            int index = 0;
            for (char ch : str.toCharArray()){
                index++;
                if (iterator.children[ch - 'a'] != null){
                    if (iterator.children[ch - 'a'].isWord){
                        break;
                    }
                    iterator = iterator.children[ch - 'a'];
                } else {
                    index = str.length();
                    break;
                }
            }
            sb.append(str.substring(0, index));
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }
    public TrieNode buildTrie(List<String> dict){
        TrieNode root = new TrieNode(' ');
        for (String str : dict){
            TrieNode iterator = root;
            for (char ch : str.toCharArray()){
                if (iterator.children[ch - 'a'] == null){
                    iterator.children[ch - 'a'] = new TrieNode(ch);
                } 
                iterator = iterator.children[ch - 'a'];
            }
            iterator.isWord = true;
        }
        return root;
    }
}