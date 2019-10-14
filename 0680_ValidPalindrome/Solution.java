class Solution {
    public boolean validPalindrome(String s) {
        int left = 0; 
        int right = s.length() - 1;
        if(s == null || s.length() <= 2) return true;
        while(left < right){
            while(left < right && s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            if(left >= right) return true;
            if(isPalin(s, left + 1, right) || isPalin(s, left, right - 1)){
                return true;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public boolean isPalin(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
