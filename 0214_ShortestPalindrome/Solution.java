class Solution {
    public String shortestPalindrome(String s) {
        int j = s.length() - 1;
        int end = s.length() - 1;
        int i = 0;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else{
                i = 0;
                end--;
                j = end;
            }
        }
        
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }
}
