class TrieNode{
    public TrieNode [] son;
    public boolean isWord;
    TrieNode(){
        son = new TrieNode[26];
        isWord = false;
    }
}
class WordDictionary {

    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        char []arr = word.toCharArray();
        for(int i = 0; i < word.length(); i++){
            int c = arr[i] - 'a';
            if(node.son[c] == null){
                node.son[c] = new TrieNode();
            }
            node = node.son[c];
        }
        node.isWord = true;        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
     public boolean search(String word) {
        // write your code here
        return find(word, root, 0);
    }
    public boolean find(String word, TrieNode node, int index){
        if(index == word.length()){
            return node.isWord;
        }
            if(word.charAt(index) == '.'){
                for(TrieNode tmp : node.son){
                    if(tmp != null && find(word, tmp, index + 1)){
                        return true;
                    }
                }
                return false;
            }
            else{
                int c = word.charAt(index) - 'a';
                TrieNode tmp = node.son[c];
                
                return tmp != null && find(word, node.son[c], index + 1);
                
            }
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
