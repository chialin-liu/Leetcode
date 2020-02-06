class MagicDictionary {

    /** Initialize your data structure here. */
    Map<Integer, Set<String>> map;
    public MagicDictionary() {
        map = new HashMap<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String s: dict){
            if(!map.containsKey(s.length())){
                map.put(s.length(), new HashSet<>());
            }
            Set<String> set = map.get(s.length());
            set.add(s);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if(!map.containsKey(word.length())){
            return false;
        }
        else{
            for(int i = 0; i < word.length(); i++){
                char cur = word.charAt(i);
                for(int j = 0; j < 26; j++){
                    if(j == (cur - 'a')) continue;
                    StringBuilder sb = new StringBuilder();
                    sb.append(word.substring(0, i));
                    sb.append((char)(j + 'a'));
                    sb.append(word.substring(i + 1));
                    if(map.get(word.length()).contains(sb.toString())){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
