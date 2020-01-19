class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1.length != words2.length){
            return false;
        }
        Map<String, Set<String>> map = new HashMap<>();
        for(List<String> pair: pairs){
            if(!map.containsKey(pair.get(0))){
                map.put(pair.get(0), new HashSet<>());
            }
            if(!map.containsKey(pair.get(1))){
                map.put(pair.get(1), new HashSet<>());
            }
            Set<String> set1 = map.get(pair.get(0));
            Set<String> set2 = map.get(pair.get(1));
            set1.add(pair.get(1));
            set2.add(pair.get(0));
        }
        
        for(int i = 0; i < words1.length; i++){
            if(words1[i].equals(words2[i])) continue;
            else if(!map.containsKey(words1[i])){
                return false;
            }
            else if(!map.get(words1[i]).contains(words2[i])){
                return false;
            }
            
        }
        return true;
    }
}
