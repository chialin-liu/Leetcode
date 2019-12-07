class Solution {
    public int minTotalDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    row.add(i);
                }
            }
        }
        for(int j = 0; j < grid[0].length; j++){
            for(int i = 0; i < grid.length; i++){
                if(grid[i][j] == 1){
                    col.add(j);
                }
            }
        }
        return getMin(row) + getMin(col);
    }
    public int getMin(List<Integer> list){
        int left = 0;
        int right = list.size() - 1;
        int sum = 0;
        while(left <= right){
            sum += list.get(right) - list.get(left);
            left++;
            right--;
        }
        return sum;
    }
}
