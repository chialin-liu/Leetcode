class Solution {
    public int maxPoints(int[][] points) {
        if(points.length == 0 || points == null) return 0;
        int len = points.length;
        if(len <= 2) return len;
        int overlap = 0;
        int maxCount = 0;
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < len - 1; i++){
            overlap = 0;
            maxCount = 0;
            map = new HashMap<>();
            for(int j = i + 1; j < len; j++){
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if(x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = getGCD(x, y);
                x = x / gcd;
                y = y / gcd;
                String slope = String.valueOf(x) + "/" + String.valueOf(y);
                int count = map.getOrDefault(slope, 0);
                count++;
                map.put(slope, count);
                maxCount = Math.max(maxCount, count);
            }
            res = Math.max(maxCount + overlap + 1, res);
        }
        return res;
        
    }
    public int getGCD(int x, int y){
        if(y == 0) return x;
        else return getGCD(y, x % y);
    }
}
