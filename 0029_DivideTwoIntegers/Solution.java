class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
            sign = -1;
        }
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        if(ldividend < ldivisor || ldividend == 0) return 0;
        long lres = divide(ldividend, ldivisor);
        int res = 0;
        if(lres > Integer.MAX_VALUE){
            res = (sign == -1)? Integer.MIN_VALUE: Integer.MAX_VALUE;
        }else{
            res = sign * (int) lres;
        }
        return res;
    }
    public long divide(long dividend, long divisor){
        if(dividend < divisor) return 0;
        long sum = divisor;
        long multiple = 1;
        while(sum + sum <= dividend){
            sum = sum + sum;
            multiple = multiple + multiple;
        }
        return multiple + divide(dividend - sum, divisor);
    }
}
