class Solution {
    public int findMaxConsecutiveOnes(int[] A) {
        int start = 0;
        int end = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        while(end < A.length){
            int cur = A[end];
            if(cur == 0){
                count++;
            }
            while(count > 1){
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
