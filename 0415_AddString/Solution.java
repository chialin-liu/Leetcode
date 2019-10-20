class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        char [] n1 = num1.toCharArray();
        char [] n2 = num2.toCharArray();
        // long n1 = Long.valueOf(num1);
        // long n2 = Long.valueOf(num2);
        // long sum = n1 + n2;
        // String res = String.valueOf(sum);
        int sum = 0;
        for(int i = n1.length - 1, j = n2.length - 1; i >= 0 || j >= 0 || sum == 1; i--, j--){
            int d1 = (i >= 0)? n1[i] - '0' : 0;
            int d2 = (j >= 0)? n2[j] - '0' : 0;
            sum = sum + d1 + d2;
            res.append(sum % 10);
            sum = sum / 10;
        }
        return res.reverse().toString();
    }
}
