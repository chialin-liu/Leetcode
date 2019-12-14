class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int res = Integer.MIN_VALUE;
        for(int left = 0; left < matrix[0].length; left++){
            int []sum = new int [matrix.length];
            for(int col = left; col < matrix[0].length; col++){
                for(int row = 0; row < matrix.length; row++){
                    sum[row] += matrix[row][col];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int cur = 0;
                for(int row = 0; row < matrix.length; row++){
                    cur += sum[row];
                    Integer num = set.ceiling(cur - k);
                    if(num != null){
                        res = Math.max(res, cur - num);
                    }
                    set.add(cur);
                }
            }
        }
        return res;
    }
}
