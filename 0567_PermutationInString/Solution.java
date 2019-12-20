class Solution {
    public boolean checkInclusion(String s1, String s2) {
       Map<Character, Integer> map = new HashMap<>();
        for(char c: s1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int size = map.size();
        int start = 0;
        int end = 0;
        while(end < s2.length()){
            char cur = s2.charAt(end);
            if(map.containsKey(cur)){
                int count = map.get(cur);
                count--;
                if(count == 0){
                    size--;
                }
                map.put(cur, count);
            }
            end++;
            while(size == 0){
                char begin = s2.charAt(start);
                if(map.containsKey(begin)){
                    int count = map.get(begin);
                    if(count == 0){
                        size++;
                    }
                    count++;
                    map.put(begin, count);
                }
                if(end - start == s1.length()){
                    return true;
                }
                start++;
            }
        }
        return false;
    }
}
