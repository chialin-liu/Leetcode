class SnapshotArray {
    Map<Integer, TreeMap<Integer, Integer>> map;
    int time;
    public SnapshotArray(int length) {
        map = new HashMap<>();
        time = 0;
        for(int i = 0; i < length; i++){
            map.put(i, new TreeMap<Integer, Integer>());
        }
    }
    
    public void set(int index, int val) {
        map.get(index).put(time, val);
    }
    
    public int snap() {
        int returnTime = time;
        time++;
        return returnTime;
    }
    
    public int get(int index, int snap_id) {
        if(map.get(index).floorEntry(snap_id) == null) return 0;
        return map.get(index).floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
