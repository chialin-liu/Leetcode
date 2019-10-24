class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        int prev = 0;
        int cur = 0;
        char sign = '+';
        int i = 0; 
        int res = 0;
        s = s.trim().replaceAll(" +", "");
        while(i < s.length()){
            cur = 0;
            while(i < s.length() && Character.isDigit(s.charAt(i))){
                cur = cur * 10 + s.charAt(i) - '0';
                i++;
            }
            if(sign == '+'){
                res = res + prev;
                prev = cur;
            }
            else if(sign == '-'){
                res = res + prev;
                prev = -cur;
            }
            else if(sign == '*'){
                prev = prev * cur;
            }
            else if(sign == '/'){
                prev = prev / cur;
            }
            if(i < s.length()){
                sign = s.charAt(i);
                i++;
            }
        }
        res = res + prev;
        return res;
    }
}
