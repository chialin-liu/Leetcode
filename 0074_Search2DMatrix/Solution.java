class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      if(matrix == null || matrix.length == 0 || matrix[0].length == 0 )  return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            int value = matrix[mid / col][mid % col];
            if(value == target){
                return true;
            }
            else if(value < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(matrix[start / col][start % col] == target){
            return true;
        }
        else if(matrix[end / col][end % col] == target){
            return true;
        }
        return false;
            
    }
}
