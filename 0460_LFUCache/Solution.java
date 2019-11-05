class LFUCache {
    Map<Integer, Integer> map;
    Map<Integer, Integer> count;
    Map<Integer, LinkedHashSet<Integer>> list;
    int capacity;
    int min;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        count = new HashMap<>();
        list = new HashMap<>();
        list.put(1, new LinkedHashSet<Integer>());
        min = -1;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        int counter = count.get(key);
        count.put(key, counter + 1);
        list.get(counter).remove(key);
        if(counter == min && list.get(counter).size() == 0){
            min++;
        }
        if(!list.containsKey(counter + 1)){
            list.put(counter + 1, new LinkedHashSet<>());
        }
        list.get(counter + 1).add(key);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if(capacity <= 0) return ;
        if(map.containsKey(key)){
            map.put(key, value);
            get(key);
            return ;
        }
        if(map.size() >= capacity){
            int evit = list.get(min).iterator().next();
            list.get(min).remove(evit);
            map.remove(evit);
            count.remove(evit); //?
        }
        map.put(key, value);
        count.put(key, 1);
        min = 1;
        list.get(min).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
