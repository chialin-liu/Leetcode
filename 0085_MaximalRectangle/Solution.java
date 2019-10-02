class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int [][]height = new int [matrix.length][matrix[0].length + 1];
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    height[i][j] = (i == 0)? 1: height[i - 1][j] + 1;
                }
                else{
                    height[i][j] = 0;
                }
            }
        }
        int max = 0;
        for(int i = 0; i < m; i++){
            int maxArea = largeArea(height[i]);
            max = Math.max(max, maxArea);
        }
        return max;       
    }
    public int largeArea(int [] height){
        if(height.length == 0 || height == null) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i <= height.length; i++){
            int cur = (i == height.length)? -1: height[i];
            while(!stack.isEmpty() && cur <= height[stack.peek()]){
                int h = height[stack.pop()];
                int left = (!stack.isEmpty())? stack.peek() + 1 : 0;
                int right = i - 1;
                int area = h * (right - left + 1);
                maxArea = Math.max(area, maxArea);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
