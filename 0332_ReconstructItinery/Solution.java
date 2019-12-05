class Solution {
    Map<String, PriorityQueue<String>> map;
    List<String> res;
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        res = new ArrayList<>();
        for(List<String> cur: tickets){
            String from = cur.get(0);
            String to = cur.get(1);
            if(!map.containsKey(from)){
                map.put(from, new PriorityQueue<>());
            }
            PriorityQueue<String> queue = map.get(from);
            queue.offer(to);
        }
        helper("JFK");
        return res;
    }
    public void helper(String cur){
        while(map.containsKey(cur) && !map.get(cur).isEmpty()){
            helper(map.get(cur).poll());
        }
        res.add(0, cur);
    }
}
