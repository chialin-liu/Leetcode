class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str == null || str.length() == 0) return 0;

        char first = str.charAt(0);
        int sign = 1; 
        long res = 0;
        int start = 0;
        if(first == '+'){
            sign = 1;
            start++;
        }
        if(first == '-'){
            sign = -1;
            start++;
        }
        for(int i = start; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                return (int) res * sign;
            }
            res = res * 10 + str.charAt(i) - '0';
            if(res * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(res * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int) res * sign;
    }
}
