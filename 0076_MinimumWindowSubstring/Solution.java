public class Solution {
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String ss , String tt) {
        // write your code here
        char []s = ss.toCharArray();
        char []t = tt.toCharArray();
        int [] cntS = new int [256];
        int [] cntT = new int [256];
        for(int i = 0; i < 256; i++){
            cntS[i] = 0;
            cntT[i] = 0;
        }
        int K = 0;
        for(int i = 0; i < tt.length(); i++){
            cntT[t[i]]++;
            if(cntT[t[i]] == 1){
                K++;
            }
        }
        int C = 0;
        int anL = -1;
        int anR = -1;
        int L = 0; 
        int R = 0;
        for(L = 0; L < ss.length(); L++){
            while(R < ss.length() && C < K){
                cntS[s[R]]++;
                if(cntS[s[R]] == cntT[s[R]]){
                    C++;
                }
                R++;
            }
            if(C == K){
                if(anL == -1 || R - L < anR - anL){
                    anL = L;
                    anR = R;
                }
            }
            cntS[s[L]]--;
            if(cntS[s[L]] == cntT[s[L]] - 1){
                C--;
            }
        }
        if(anL == -1){
            return "";
        }
        else{
            return ss.substring(anL, anR);
        }
    }
}
