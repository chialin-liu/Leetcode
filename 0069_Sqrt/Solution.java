class Solution {
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        while(left <= right){
            long mid = (right - left) / 2 + left;
            if(mid * mid == x){
                return (int) mid;
            }
            else if(mid * mid < x){
                left = (int)mid + 1;
            }
            else{
                right = (int)mid - 1;
            }
        }
        return right;
    }
}
