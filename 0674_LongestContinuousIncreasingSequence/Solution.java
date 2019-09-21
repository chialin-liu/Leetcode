class Solution {
    public int findLengthOfLCIS(int[] A) {
if(A == null || A.length == 0) return 0;
        int ans = 1;
        int len = 1;
        for(int i = 1; i < A.length; i++){
            if(A[i] > A[i - 1]) {
                len ++;
            }
            else{
                len = 1;
            }
            ans = Math.max(ans, len);
        }
        // len = 1;
        // for(int i = A.length - 2; i >= 0; i--){
        //     if(A[i] > A[i + 1]){
        //         len++;
        //     }
        //     else{
        //         len = 1;
        //     }
        //     ans = Math.max(ans, len);
        // }
        return ans;        
    }
}
