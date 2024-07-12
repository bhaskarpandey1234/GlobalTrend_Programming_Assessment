package trie;

public class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // 26 letters in the English alphabet
        isEndOfWord = false;
    }
}
