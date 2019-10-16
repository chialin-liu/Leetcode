class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character cur: s.toCharArray()){
            if(map.containsKey(cur)){
                int val = map.get(cur);
                val++;
                map.put(cur, val);
            }
            else{
                map.put(cur, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        List<Character> [] bucket = new List[s.length() + 1];
        for(Character cur: map.keySet()){
            int freq = map.get(cur);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(cur);
        }
        int idx = 0;
        for(int i = bucket.length - 1; i >= 0; i--){
            if(bucket[i] != null){
                idx = 0;
                while(bucket[i].size() != idx){
                    int times = map.get(bucket[i].get(idx));
                    for(int t = 0; t < times; t++){
                        sb.append(bucket[i].get(idx));
                    }
                    idx++;
                }
            }
        }
        return sb.toString();
    }
}
