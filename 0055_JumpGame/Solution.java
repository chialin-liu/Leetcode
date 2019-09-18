public class Solution {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        // write your code here
        boolean [] f = new boolean[A.length];
        f[0] = true;
        for(int i = 1; i < A.length; i++){
            f[i] = false;
            for(int j = 0; j < i; j++){
                if(j + A[j] >= i && f[j] == true){
                    f[i] = true;
                }
            }
        }
        return f[A.length - 1];
    }
}
