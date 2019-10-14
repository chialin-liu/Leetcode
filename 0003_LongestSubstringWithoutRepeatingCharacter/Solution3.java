class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s == null) return 0;
        int res = Integer.MIN_VALUE;
        int left = 0;
        int right = -1;
        int [] alpha = new int [256];
        Set<Character> set = new HashSet<>();
        while(left < s.length()){
            if(right + 1 < s.length() && !set.contains(s.charAt(right + 1))){
                set.add(s.charAt(right + 1));
                right++;
                
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }
            res = Math.max(res, right - left + 1 );
        }
        return res;
    }
}
