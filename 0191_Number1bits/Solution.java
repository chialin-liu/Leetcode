public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int index = 32;
        while(index != 0){
            if((n & 1) == 1){
                count++;
            }
            n = n >> 1;
            index--;
        }
        return count;
    }
}
