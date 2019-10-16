class Solution {
    public boolean isHappy(int n) {
        if(n == 1) return true;
        int squareSum = 0;
        int remain = 0;
        Set<Integer> set = new HashSet<>();
        while(set.add(n)){
            squareSum = 0;
            while(n > 0){
                remain = n % 10;
                squareSum = squareSum + remain * remain;
                n = n / 10;
            }
            if(squareSum == 1){
                return true;
            }
            else{
                n = squareSum;
            }
        }
        return false;
    }
}
