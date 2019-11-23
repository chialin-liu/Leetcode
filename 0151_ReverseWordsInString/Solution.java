class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        String [] str = s.trim().split("\\s+");
        String res = "";
        for(int i = str.length - 1; i >= 1; i--){
            // if(str[i] != " "){
               res += str[i] + " "; 
            // }
            
        }
        res += str[0];
        return res;
    }
}
