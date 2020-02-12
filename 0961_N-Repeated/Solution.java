class Solution {
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: A){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key: map.keySet()){
            int count = map.get(key);
            if(count == A.length / 2){
                return key;
            }
        }
        return -1;
    }
}
