class Solution {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        int [] alpha = new int[26];
        for(int i = 0; i < s.length(); i++){
            alpha[s.charAt(i) - 'a']++;
        }
        boolean allLength = true;
        for(int i = 0; i < s.length(); i++){
            if(alpha[s.charAt(i) - 'a'] < k) {
                allLength = false;
            }
        }
        if(allLength) return s.length();
        int start = 0;
        int cur = 0;
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            if(alpha[s.charAt(i) - 'a'] < k) {
                res = Math.max(res, longestSubstring(s.substring(start, i), k));
                start = i + 1;
            }
        }
        return Math.max(res, longestSubstring(s.substring(start), k));
    }
}
