public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if(s == null || s.length() == 0) return 0;
        int []map = new int [256];
        int res = 0;
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            while(j < s.length() && map[s.charAt(j)] == 0){
                map[s.charAt(j)] = 1;
                res = Math.max(res, j - i + 1);
                j++;
            }
            map[s.charAt(i)] = 0;
        }
        return res;
    }
}
