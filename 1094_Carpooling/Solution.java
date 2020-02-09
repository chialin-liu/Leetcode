class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int []t: trips){
            map.put(t[1], map.getOrDefault(t[1], 0) + t[0]);
            map.put(t[2], map.getOrDefault(t[2], 0) - t[0]);
        }
        int now = 0;
        for(int key: map.keySet()){
            int count = map.get(key);
            now += count;
            if(now > capacity){
                return false;
            }
        }
        return true;
    }
}
