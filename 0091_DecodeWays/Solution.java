public class Solution {
    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // write your code here
        if(s == null || s.length() == 0) return 0;
        char []c = s.toCharArray();
        int [] f = new int [s.length() + 1];
        f[0] = 1;
        for(int i = 1; i <= s.length(); i++){
            if(c[i - 1] != '0'){
                f[i] += f[i - 1];
            }
            if(i >= 2 && (c[i - 2] == '1' || (c[i - 2] == '2' && c[i - 1] <= '6'))){
                f[i] += f[i - 2];
            }
        }
        return f[s.length()];
    }
}
