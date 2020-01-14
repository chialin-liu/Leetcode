class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int []time: times){
            if(!map.containsKey(time[0])){
                map.put(time[0], new HashMap<>());
            }
            if(!map.containsKey(time[1])){
                map.put(time[1], new HashMap<>());
            }
            Map<Integer, Integer> tmp = map.get(time[0]);
            tmp.put(time[1], time[2]);
        }
        Set<Integer> set = new HashSet<>();
        PriorityQueue<int []> queue = new PriorityQueue<>(new Comparator<int []>(){
            public int compare(int []a, int []b){
                return a[0] - b[0];
            }
        });
        queue.offer(new int[]{0, K});
        // set.add(K);
        int []cur = new int[2];
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                cur = queue.poll();
                if(!set.contains(cur[1])){
                    N--;
                }
                if(N == 0) return cur[0];
                set.add(cur[1]);
                Map<Integer, Integer> list = map.get(cur[1]);
                for(int key: list.keySet()){
                    if(!set.contains(key)){
                        queue.offer(new int[]{cur[0] + list.get(key), key});
                    }
                }
            }
        }
        return N == 0? cur[0]: -1;
        
    }
}
