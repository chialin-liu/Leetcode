class AutocompleteSystem {
    class TrieNode{
        Map<Character, TrieNode> char_to_child;
        Map<String, Integer> string_to_freq;
        public TrieNode(){
            char_to_child = new HashMap<>();
            string_to_freq = new HashMap<>();
        }
    }
    TrieNode root;
    String prefix;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        for(int i = 0; i < sentences.length; i++){
            buildTrie(sentences[i], times[i]);
        }
    }
    public void buildTrie(String sent, int count){
        TrieNode cur = root;
        for(char c: sent.toCharArray()){
            TrieNode next = cur.char_to_child.get(c);
            if(next == null){
                next = new TrieNode();
                cur.char_to_child.put(c, next);
            }
            cur = next;
            cur.string_to_freq.put(sent, cur.string_to_freq.getOrDefault(sent, 0) + count);
        }
    }
    public List<String> input(char c) {
        if(c == '#'){
            buildTrie(prefix, 1);
            prefix = "";
            return new ArrayList<String>();
        }
        prefix = prefix + c;
        TrieNode cur = root;
        for(char cc: prefix.toCharArray()){
            TrieNode next = cur.char_to_child.get(cc);
            if(next == null){
                List<String> list = new ArrayList<>();
                // list.add("a");
                return list;
            }
            cur = next;
        }
        // Comparator<Map.Entry<String, Integer>> comp = new Comparator<Map.Entry<String, Integer>>(){
        //     public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
        //         if(o1.getValue() == o2.getValue()){
        //             return o1.getKey().compareTo(o2.getKey());
        //         }
        //         else{
        //             return o2.getValue() - o1.getValue();
        //         }
        //     }
        // };
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                if(o1.getValue() == o2.getValue()){
                    return o1.getKey().compareTo(o2.getKey());
                }
                else{
                    return o2.getValue() - o1.getValue();
                }
            }    
        });
        pq.addAll(cur.string_to_freq.entrySet());
        int k = 3;
        List<String> res = new ArrayList<>();
        while(!pq.isEmpty() && k > 0){
            res.add((String)pq.poll().getKey());
            k--;
        }
        return res;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
