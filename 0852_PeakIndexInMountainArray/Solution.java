class Solution {
    public int peakIndexInMountainArray(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(A[mid] == A[mid + 1]){
                end = mid;
            }
            else if(A[mid] < A[mid + 1]){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(A[end] >= A[start]){
            return end;
        }
        else{
            return start;
        }
    }
}
