class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < points.length; i++){
            for(int j = 0; j < points.length; j++){
                if(i == j) continue;
                int dis = getDistance(points[i], points[j]);
                // if(map.containsKey(dis)){
                    map.put(dis, map.getOrDefault(dis, 0) + 1);
                //     int val = map.get(dis);
                //     val++;
                //     map.put(dis, val);
                // }
                // else{
                //     map.put(dis, 1);
                // }
            }
            for(int val : map.values()){
                res = res + (val * (val - 1));
            }
            map.clear();
        }
        return res;
    }
    public int getDistance(int []x, int []y){
        int dx = x[0] - y[0];
        int dy = x[1] - y[1];
        return dx * dx + dy * dy;
    }
}
