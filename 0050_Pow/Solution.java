public class Solution {
    /**
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        // write your code here
        if(n > 0){
            return pow(x, n);
        }
        else{
            return 1 / pow(x, n);
        }
    }
    public double pow(double x, int n){
        if(n == 0){
            return 1;
        }
        double y = pow(x, n / 2);
        if(n % 2 == 0){
            return y * y;
        }else{
            return  y * y * x;
        }
    }
}
