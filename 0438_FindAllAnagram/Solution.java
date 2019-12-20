class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        int total;
        for(char c: p.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, 1);
            }
            else{
                int count = map.get(c);
                count++;
                map.put(c, count);
            }
        }
        total = map.size();
        int start = 0;
        int end = 0;
        List<Integer> res = new ArrayList<>();
        while(end < s.length()){
            char cur = s.charAt(end);
            if(map.containsKey(cur)){
                int count = map.get(cur);
                count--;
                map.put(cur, count);
                if(count == 0){
                    total--;
                }
            }
            end++;
            while(total == 0){
                char begin = s.charAt(start);
                if(map.containsKey(begin)){
                    int count = map.get(begin);
                    if(count == 0){
                        total++;
                    }
                    count++;
                    map.put(begin, count);
                    
                }
                if(end - start == p.length()){
                    res.add(start);
                }
                start++;
            }
            
        }
        return res;
    }
}
