public class RandomizedSet {
    private List<Integer> array;
    private Map<Integer, Integer> map;
    Random rand;
    public RandomizedSet() {
        // do intialization if necessary
        array = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        // write your code here
        if(map.containsKey(val)){
            return false;
        }else{
            map.put(val, array.size());
            array.add(val);
            return true;
        }
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        // write your code here
        if(!map.containsKey(val)){
            return false;
        }else{
            int index = map.get(val);
            if(index < array.size() - 1){
                int lastValue = array.get(array.size() - 1);
                array.set(index, lastValue);
                map.put(lastValue, index);
            }
            array.remove(array.size() - 1);
            map.remove(val);
            return true;
        }
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        // write your code here
        return array.get(rand.nextInt(array.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */
