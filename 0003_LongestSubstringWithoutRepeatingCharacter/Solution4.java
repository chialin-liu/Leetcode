class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int max = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        while(left < s.length()){
            while(right < s.length() && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                max = Math.max(max, set.size());
                right++;
                
            }
            set.remove(s.charAt(left));
            left++;
        }
        return max;
    }
}
