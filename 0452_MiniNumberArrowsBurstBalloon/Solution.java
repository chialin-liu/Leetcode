class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0 || points[0].length == 0) return 0;
        int res = 1;
        Arrays.sort(points, new Comparator<int []>(){
            public int compare(int []p1, int []p2){
                return p1[0] - p2[0];
            }
        });
        int end = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(points[i][0] <= end){
                end = Math.min(end, points[i][1]);
            }
            else{
                res++;
                end = points[i][1];
            }
        }
        return res;
    }
}
