class Solution {
    public String minWindow(String s, String t) {
        if(t == null || t.length() == 0 || s == null || s.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        int size = 0;
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        size = map.size();
        int start = 0;
        int end = 0;
        int res = Integer.MAX_VALUE;
        String resStr = "";
        while(end < s.length()){
            char cur = s.charAt(end);
            if(map.containsKey(cur)){
                int count = map.get(cur);
                count--;
                if(count == 0) {
                    size--;
                }
                map.put(cur, count);
            }
            end++;
            while(size == 0){
                char begin = s.charAt(start);
                if(map.containsKey(begin)){
                    int count = map.get(begin);
                    if(count == 0){
                        size++;
                    }
                    count++;
                    map.put(begin, count);
                }
                if(end - start >= t.length()){
                    if(end - start < res){
                        resStr = s.substring(start, end);
                        res = end - start;
                    }
                }
                start++;
            }
        }
        return resStr;
    }
}
