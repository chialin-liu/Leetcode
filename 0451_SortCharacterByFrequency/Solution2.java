class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((a, b)-> map.get(b) - map.get(a));
        for(char c: map.keySet()){
            queue.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        String res = "";
        while(!queue.isEmpty()){
            sb = new StringBuilder();
            char c = queue.poll();
            int val = map.get(c);
            for(int i = 0; i < val; i++){
                sb.append(c);
            }
            res += sb.toString();
        }
        return res;
    }
}
