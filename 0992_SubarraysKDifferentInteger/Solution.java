class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return lengthOfLongestSubstringKDistinct(A, K) - lengthOfLongestSubstringKDistinct(A, K - 1);
    }
    public int lengthOfLongestSubstringKDistinct(int [] s, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int end = 0;
        int start = 0;
        int count = 0;
        int max = 0;
        while(end < s.length){
            int cur = s[end];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            if(map.get(cur) == 1){
                count++;
            }
            while(count > k){
                int begin = s[start];
                if(map.containsKey(begin)){
                    int cnt = map.get(begin);
                    if(cnt == 1){
                        count--;
                    }
                    map.put(begin, cnt - 1);
                }
                start++;
            }
            max += end - start + 1;
            end++;
        }
        return max;        
    }    
}
