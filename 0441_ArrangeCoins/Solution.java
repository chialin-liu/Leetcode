class Solution {
    public int arrangeCoins(int n) {
        int count = 1;
        
        while(n > 0){
            n -= count;
            if(n < 0) return count - 1;
            else if(n == 0) return count;
            count++;
        }
        return 0;
    }
}
