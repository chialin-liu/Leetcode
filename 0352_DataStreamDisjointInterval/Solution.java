class SummaryRanges {

    /** Initialize your data structure here. */
    TreeMap<Integer, List<Integer>> map;
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if(map.containsKey(val)) return;
        Integer lowerKey = map.lowerKey(val);
        Integer higherKey = map.higherKey(val);
        if(lowerKey != null && higherKey != null && map.get(lowerKey).get(1) + 1 == val && (map.get(higherKey).get(0) == val + 1)){
            List<Integer> high = map.get(higherKey);
            List<Integer> low = map.get(lowerKey);
            low.remove(low.size() - 1);
            low.add(high.get(1));
            map.remove(higherKey);
            // map.put(lowerKey, low);
        }
        else if(lowerKey != null && val <= map.get(lowerKey).get(1) + 1){
            List<Integer> low = map.get(lowerKey);
            int end = low.get(1);
            low.remove(low.get(1));
            low.add(Math.max(val, end));
        }
        else if(higherKey != null && val + 1 == map.get(higherKey).get(0)){
            List<Integer> high = map.get(higherKey);
            high.remove(high.get(0));
            high.add(0, val);
            map.remove(higherKey);
            map.put(val, high);
        }
        else{
            List<Integer> list = new ArrayList<>();
            list.add(val);
            list.add(val);
            map.put(val, list);
        }
    }
    
    public int[][] getIntervals() {
        int [][]res = new int [map.size()][2];
        int count = 0;
        for(List<Integer> list: map.values()){
            res[count][0] = list.get(0);
            res[count][1] = list.get(1);
            count++;
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
