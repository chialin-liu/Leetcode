class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        String []ASplit = A.split(" ");
        String []BSplit = B.split(" ");
        List<String> uncomm = new ArrayList<>();
        for(String str: ASplit){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for(String str: BSplit){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for(String key: map.keySet()){
            if(map.get(key) == 1){
                uncomm.add(key);
            }
        }
        String []res = new String[uncomm.size()];
        int index = 0;
        for(String cur: uncomm){
            res[index] = cur;
            index++;
        }
        return res;
    }
}
