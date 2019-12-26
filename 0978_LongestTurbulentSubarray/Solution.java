class Solution {
    public int maxTurbulenceSize(int[] A) {
        int index = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < A.length; i++){
            int c = Integer.compare(A[i - 1], A[i]);
            if(c == 0){
                index = i;
            }
            else if(i == A.length - 1 || c * Integer.compare(A[i], A[i + 1]) != -1){
                max = Math.max(max, i - index + 1);
                index = i;
            }
        }
        return max == Integer.MIN_VALUE? 1: max;
    }
}
