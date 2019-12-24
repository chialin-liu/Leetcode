class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int end = 0;
        int start = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        int maxCount = Integer.MIN_VALUE;
        while(end < s.length()){
            char cur = s.charAt(end);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            maxCount = Math.max(maxCount, map.get(cur));
            while(end - start + 1 - maxCount > k){
                char begin = s.charAt(start);
                map.put(begin, map.get(begin) - 1);
                start++;
            }
            max = Math.max(max, end - start + 1);
            end++;
        }
        return max == Integer.MIN_VALUE? 0: max;           
    }
}
