public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String ss, int k) {
        // write your code here
        char []s = ss.toCharArray();
        int []cntS = new int [256];
        for(int i = 0; i < 256; i++){
            cntS[i] = 0;
        }
        int L = 0;
        int R = 0;
        int C = 0;
        int res = 0;
        for(R = 0; R < ss.length(); R++){
           
                cntS[s[R]]++;
                if(cntS[s[R]] == 1){
                    C++;
                }
               
            
            
            while(C > k){
                cntS[s[L]]--;
                if(cntS[s[L]] == 0){
                    C--;
                }
                L++;
            }
            res = Math.max(res, R - L + 1);
        }
        return res;
    }
}
