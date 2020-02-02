class WordDistance {
    Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        int index = 0;
        for(String word: words){
            if(!map.containsKey(word)){
                map.put(word, new ArrayList<>());
            }
            List<Integer> set = map.get(word);
            set.add(index);
            index++;
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> index1 = map.get(word1);
        List<Integer> index2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        for(int i = 0, j = 0; i < index1.size() && j < index2.size();){
            min = Math.min(min, Math.abs(index1.get(i) - index2.get(j)));
            if(index1.get(i) > index2.get(j)){
                j++;
            }
            else{
                i++;
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
