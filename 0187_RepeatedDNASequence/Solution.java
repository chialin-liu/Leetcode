class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        char []arr = s.toCharArray();
        for(int i = 0; i + 10 <= arr.length; i++){
            String cur = s.substring(i, i + 10);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for(String key: map.keySet()){
            if(map.get(key) > 1){
                res.add(key);
            }
        }
        return res;
    }
}
