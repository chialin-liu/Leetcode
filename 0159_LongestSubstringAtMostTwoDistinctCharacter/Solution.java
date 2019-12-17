class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int res = 0;
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int end = 0;
        int begin = 0;
        int counter = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) == 1){
                counter++;
            }
            while(counter > 2){
                char start = s.charAt(begin);
                int count = map.get(start);
                count--;
                map.put(start, count);
                if(count == 0){
                    counter--;
                }
                begin++;
            }
            res = Math.max(res, end - begin + 1);
            end++;
        }
        return res;
    }
}
