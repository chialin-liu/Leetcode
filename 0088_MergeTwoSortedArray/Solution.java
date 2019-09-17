class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int []res = new int[m + n];
        int idxA = 0;
        int idxB = 0;
        int idxC = 0;
        if(m == 0 && n == 0) return ;
        while(idxA < m && idxB < n){
            if(nums1[idxA] < nums2[idxB]){
                res[idxC] = nums1[idxA];
                idxA++;
                idxC++;
            }
            else if(nums1[idxA] > nums2[idxB]){
                res[idxC] = nums2[idxB];
                idxB++;
                idxC++;
            }
            else{
                res[idxC] = nums1[idxA];
                idxA++;
                idxC++;
            }
        }
        while(idxA < m){
           res[idxC] = nums1[idxA];
                idxA++;
                idxC++; 
        }
        while(idxB < n){
                res[idxC] = nums2[idxB];
                idxB++;
                idxC++; 
        }
        for(int i = 0; i < m + n; i++){
            nums1[i] = res[i];
        }
        // nums1 = res;
    }
}
