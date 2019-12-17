class Solution {
    public boolean isOneEditDistance(String s, String t) {
        // if(s == null || s.length() == 0 || t == null || t.length) return false;
        if(s.length() + 1 == t.length()){
            for(int i = 0; i < s.length(); i++){
                char charS = s.charAt(i);
                char charT = t.charAt(i);
                char charTNeigh = t.charAt(i + 1);
                if(charS == charT || charS == charTNeigh) continue;
                else {
                    return false;
                }
            }
        }
        else if(s.length() == t.length() + 1){
            for(int i = 0; i < t.length(); i++){
                char charT = t.charAt(i);
                char charS = s.charAt(i);
                char charSNeigh = s.charAt(i + 1);
                if(charT == charS || charT == charSNeigh) continue;
                else {
                    return false;
                }
            }
        }
        else if(s.length() == t.length() && s.length() > 0){
            int count = 0;
            for(int i = 0; i < t.length(); i++){
                char charT = t.charAt(i);
                char charS = s.charAt(i);
                if(charT != charS){
                    count++;
                }
            }
            if(count > 1){
                return false;
            }
            else if(count == 0){
                return false;
            }
        }
        else{
            return false;
        }
        return true;
        
    }
}
