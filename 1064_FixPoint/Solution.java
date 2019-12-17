class Solution {
    public int fixedPoint(int[] A) {
        if(A == null || A.length == 0) return -1;
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(A[mid] == mid){
                end = mid;
            }
            else if(A[mid] > mid){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(A[start] == start){
            return start;
        }
        else if(A[end] == end){
            return end;
        }
        else{
            return -1;
        }
    }
}
