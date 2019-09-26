class TrieNode{
    public TrieNode []son;
    public boolean isWord;
    TrieNode(){
        son = new TrieNode[26];
        isWord = false;
        for(int i = 0; i < 26; i++){
            son[i] = null;
        }
    }
}
public class Trie {
    public TrieNode root;
    public Trie() {
        // do intialization if necessary
        root = new TrieNode();
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        TrieNode node = root;
        char[] charArr = word.toCharArray();
        for(int i = 0; i < word.length(); i++){
            int c = charArr[i] - 'a';
            if(node.son[c] == null){
                node.son[c] = new TrieNode();
            }
            node = node.son[c];
        }
        node.isWord = true;
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        TrieNode node = root;
        char []charArr = word.toCharArray();
        for(int i = 0; i < word.length(); i++){
            int c = charArr[i] - 'a';
            if(node.son[c] == null){
              return false;
            }
            node = node.son[c];
        }
        return node.isWord;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        TrieNode node = root;
        char []charArr = prefix.toCharArray();
        for(int i = 0; i < prefix.length(); i++){
            int c = charArr[i] - 'a';
            if(node.son[c] == null){
              return false;
            }
            node = node.son[c];
        }
        return true;
    }
}
