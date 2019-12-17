class Solution {
    public boolean isReflected(int[][] points) {
        if(points == null) return true;
        Set<String> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < points.length; i++){
            max = Math.max(max, points[i][0]);
            min = Math.min(min, points[i][0]);
            int x = points[i][0];
            int y = points[i][1];
            String cur = String.valueOf(x) + "/" + String.valueOf(y);
            set.add(cur);
        }
        int sum = max + min;
        for(int i = 0; i < points.length; i++){
            int x = sum - points[i][0];
            int y = points[i][1];
            String cur = String.valueOf(x) + "/" + String.valueOf(y);
            if(!set.contains(cur)){
                return false;
            }
        }
        return true;
    }
}
