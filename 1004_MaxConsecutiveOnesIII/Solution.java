class Solution {
    public int longestOnes(int[] A, int K) {
        int start = 0;
        int end = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        while(end < A.length){
            int cur = A[end];
            if(cur == 0){
                count++;
            }
            while(count > K){
                int begin = A[start];
                if(begin == 0){
                    count--;
                }
                start++;
            }
            max = Math.max(max, end - start + 1);
            end++;           
        }
        return max;
    }
}
