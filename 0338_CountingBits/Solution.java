public class Solution {
    /**
     * @param num: a non negative integer number
     * @return: an array represent the number of 1's in their binary
     */
    public int[] countBits(int num) {
        // write your code here
        int [] f = new int [num + 1];
        if(num == 0) return f;
        f[0] = 0;
        for(int i = 1; i <= num; i++){
            f[i] = f[i >> 1] + i % 2;
        }
        return f;
    }
}
