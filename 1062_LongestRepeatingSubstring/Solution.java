class Solution {
    public int longestRepeatingSubstring(String S) {
        if(S == null || S.length() == 0) return 0;
        Map<String, Integer> map = new HashMap<>();
        int largeLen = S.length() - 1;
        for(int len = largeLen; len >= 1; len--){
            for(int i = 0; i + len - 1 < S.length(); i++){
                String cur = S.substring(i, i + len);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                if(map.get(cur) > 1){
                    return len;
                }
            }
            map.clear();
        }
        return 0;
    }
}
