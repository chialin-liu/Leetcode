class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while(left <= right){
            long mid = (right - left) / 2 + left;
            if(mid * mid == num){
                return true;
            }
            else if(mid * mid < num){
                left = (int)mid + 1;
            }
            else{
                right = (int)mid - 1;
            }
        }
        return false;
    }
}
