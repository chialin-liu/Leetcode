class TopVotedCandidate {
    TreeMap<Integer, Integer> treemap;//time, leader
    public TopVotedCandidate(int[] persons, int[] times) {
        // set = new TreeSet<>(new Comparator<Vote>(){
        //     public int compare(Vote v1, Vote v2){
        //         return v1.time - v2.time;
        //     }
        // });
        treemap = new TreeMap<>();
        int leader = -1;
        int num = 0;
        int p = 0;
        int t = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < persons.length; i++){
            p = persons[i];
            t = times[i];
            int count = map.getOrDefault(p, 0) + 1;
            if(count >= num){
                leader = p;
                num = count;            
            }
            map.put(p, count);
            treemap.put(t, leader);
        }
    }
    
    public int q(int t) {
        Integer floorPerson = treemap.floorKey(t);
        if(floorPerson == null) return -1;
        return treemap.get(floorPerson);
        // return floorPerson;
    }
    // class Vote{
    //     int person;
    //     int time;
    //     public Vote(int p, int t){
    //         this.person = p;
    //         this.time = t;
    //     }
    // }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
