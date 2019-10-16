class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            if(map.containsKey(i)){
                int val = map.get(i);
                val++;
                map.put(i, val);
            }
            else{
                map.put(i, 1);
            }
        }
        List<Integer> [] bucket = new List[nums.length + 1];
        for(int key: map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            
                bucket[freq].add(key);
            
        }
        List<Integer> res = new ArrayList<>();
        for(int i = bucket.length - 1; i >= 0 && res.size() < k; i-- ){
            if(bucket[i] != null){
                res.addAll(bucket[i]);
            }
        }
        return res;
    }
}
