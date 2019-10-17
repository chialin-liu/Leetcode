class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String cur: strs){
            int [] count = new int[26];
            for(Character car: cur.toCharArray()){
                count[car - 'a']++;
            }
            String st = "";
            for(int i = 0; i < count.length; i++){
                if(count[i] != 0){
                    st = st + String.valueOf(count[i]) + String.valueOf((char) i + 'a');
                }
            }
            if(map.containsKey(st)){
                List<String> list = map.get(st);
                list.add(cur);
                map.put(st, list);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(cur);
                map.put(st, list);
            }
        }
        // List<List<String>> res = new ArrayList<>();
        // for(List<String> list: map.values()){
        //     res.add(list);
        // }
        return new ArrayList<>(map.values());
    }
}
