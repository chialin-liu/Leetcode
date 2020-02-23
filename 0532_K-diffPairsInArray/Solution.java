class Solution {
    public int findPairs(int[] nums, int k) {
        if(k < 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        int size = 0;
        for(int key: map.keySet()){
            int count = map.get(key);
            if(k == 0){
                if(count >= 2){
                    size++;
                }
            }
            else{
                if(map.containsKey(key + k) && !set.contains(key + k)){
                    set.add(key);
                    set.add(key + k);
                    size++;
                }
                if(map.containsKey(key - k) && !set.contains(key - k)){
                    set.add(key);
                    set.add(key - k);
                    size++;
                }
            }
        }
        return size;
    }
}
