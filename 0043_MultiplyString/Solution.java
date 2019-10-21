class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return "0";
        int [] digit = new int [num1.length() + num2.length()];
        int sum = 0;
        for(int i = num1.length() - 1; i >= 0; i--){
            for(int j = num2.length() - 1; j >= 0; j--){
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p2 = i + j + 1;
                int p1 = i + j;
                sum = product + digit[p2];
                digit[p2] = sum % 10;
                digit[p1] = (sum / 10 + digit[p1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < digit.length; i++){
            if(!(digit[i] == 0 && sb.length() == 0)){
                sb.append(digit[i]);
            }
        }
        return sb.length() > 0? sb.toString() : "0";
        
    }
}
