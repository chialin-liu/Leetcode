class Solution {
    public boolean isMatch(String s, String p) {
        int star = -1;
        int s_p = 0;
        int p_p = 0;
        int match = 0;
        while(s_p < s.length()){
            if(p_p < p.length() && (s.charAt(s_p) == p.charAt(p_p) || p.charAt(p_p) == '?')){
                s_p++;
                p_p++;
            }
            else if(p_p < p.length() && p.charAt(p_p) == '*'){
                star = p_p;
                match = s_p;
                p_p++;
            }
            else if(star != -1){
                match++;
                s_p = match;
                p_p = star + 1;
            }
            else
                return false;
        }
        while(p_p < p.length() && p.charAt(p_p) == '*'){
            p_p++;
        }
        return p_p == p.length();
    }
}
