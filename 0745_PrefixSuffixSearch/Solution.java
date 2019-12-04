class WordFilter {
    class TrieNode{
        TrieNode []children;
        int weight;
        public TrieNode(){
            this.children = new TrieNode[27];
        }
    }
    TrieNode root;
    
    public WordFilter(String[] words) {
        root = new TrieNode();
        for(int weight = 0; weight < words.length ; weight++){
            String str = words[weight] + "{";
            for(int i = 0; i < str.length(); i++){
                TrieNode curNode = root;
                for(int j = i; j < 2 * str.length() - 1; j++){
                    char c = str.charAt(j % str.length());
                    if(curNode.children[c - 'a'] == null){
                        curNode.children[c - 'a'] = new TrieNode();
                    }
                        curNode = curNode.children[c - 'a'];
                        curNode.weight = weight;
                    
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        String compare = suffix + "{" + prefix;
        TrieNode curNode = root;
        for(char cur: compare.toCharArray()){
            if(curNode.children[cur - 'a'] == null) return -1;
            curNode = curNode.children[cur - 'a'];
        }
        return curNode.weight;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
