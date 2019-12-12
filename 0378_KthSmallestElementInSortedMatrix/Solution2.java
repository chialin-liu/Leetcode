class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = matrix[0][0];
        int end = matrix[m - 1][n - 1];
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(count(mid, matrix, k) < k){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(count(start, matrix, k) >= k){
            return start;
        }
        else{
            return end;
        }
    }
    public int count(int mid, int [][]matrix, int k){
        int count = 0;
        int n = matrix[0].length;
        int i = matrix.length - 1;
        int j = 0;
        while(i >= 0 && j < n){
            if(matrix[i][j] <= mid){
                count += i + 1;
                j++;
            }
            else{
                i--;
            }
        }
        return count ;
    }
}
