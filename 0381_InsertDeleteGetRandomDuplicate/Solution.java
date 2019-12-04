class RandomizedCollection {
    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    Random rnd;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rnd = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = true;
        if(!map.containsKey(val)){
            contain = false;
            map.put(val, new HashSet<Integer>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return !contain;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int deleteIndex = map.get(val).iterator().next();
        map.get(val).remove(deleteIndex);
        if(map.get(val).size() == 0){
            map.remove(val);
        }
        if(deleteIndex != list.size() - 1){
            int insertValue = list.get(list.size() - 1);
            map.get(insertValue).remove(list.size() - 1); 
            map.get(insertValue).add(deleteIndex);
            list.set(deleteIndex, insertValue);
            list.remove(list.size() - 1);
        }
        else{
            list.remove(list.size() - 1);
        }
        return true;
        
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rnd.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
