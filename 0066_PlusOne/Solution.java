class Solution {
    public int[] plusOne(int[] digits) {
        int sum = 1;
        int [] res = new int [digits.length + 1];
        int [] res_v2 = new int [digits.length];
        if(digits == null || digits.length == 0) return res_v2;
        for(int i = digits.length - 1; i >= 0; i--){
            sum += digits[i] ;
            res[i + 1] = sum % 10;
            res_v2[i] = sum % 10;
            sum = sum / 10; 
        }
        if(sum == 1){
            res[0] = 1;
            return res;
        }
        else{
            return res_v2;
        }
    }
}
