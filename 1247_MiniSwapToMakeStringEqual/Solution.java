class Solution {
    public int minimumSwap(String s1, String s2) {
        int x1 = 0; 
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        for(int i = 0; i < s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1 == c2) continue;
            if(c1 == 'x'){
                x1++;
            }
            else{
                y1++;
            }
            if(c2 == 'x'){
                x2++;
            }
            else{
                y2++;
            }
        }
        if(((x1 + x2) % 2 != 0) || ((y1 + y2) % 2 != 0)){
            return -1;
        }
        int swap = x1 / 2 + y1 / 2 + (x1 % 2) * 2;
        return swap;
    }
}
