class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String cur: words){
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? b.compareTo(a): map.get(a) - map.get(b));
        for(String cur: map.keySet()){
            queue.offer(cur);
            if(queue.size() > k){
                queue.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while(!queue.isEmpty()){
            res.add(0, queue.poll());
        }
        return res;
    }
}
