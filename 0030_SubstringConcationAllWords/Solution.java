class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String str: words){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        if(s == null || s.length() == 0 || words == null || words.length == 0) return list;
        int m = words.length;
        int n = words[0].length();
        for(int i = 0; i <= s.length() - m * n; i++){
            Map<String, Integer> comp = new HashMap<>(map);
            int k = m;
            int j = i;
            while(k > 0){
                String cur = s.substring(j, j + n);
                if(!comp.containsKey(cur) || comp.get(cur) < 1){
                    break;
                }
                int count = comp.get(cur);
                comp.put(cur, count - 1);
                k--;
                j = j + n;
            }
            if(k == 0) {
                list.add(i);
            }
        }
        return list;
    }
}
