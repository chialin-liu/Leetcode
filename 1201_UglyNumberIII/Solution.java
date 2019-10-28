class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int low = 1;
        int high = 2 * 1000000000;
        int mid ;
        int result = 0;
        while(low <= high){
            mid = low + (high - low) / 2;
            int number = count(a, b, c, mid);
            if(number >= n){
                result = mid;
                high = mid - 1;
            }

            else{
                low = mid + 1;
            }
        }
        return result;
    }
    public int count(long a, long b, long c, long mid){
            long ab = lcm(a, b);
            long bc = lcm(b, c);
            long ac = lcm(a, c);
            long abc = lcm(a, bc);
            long countNum = mid / a + mid / b + mid / c - mid / ab - mid / bc - mid / ac + mid / abc; 
        return (int) countNum;
    }
    public long gcd(long a, long b){
        return b == 0? a : gcd(b, a % b);
    }
    public long lcm(long a, long b){
        return a * b / gcd(a, b);
    }
}
