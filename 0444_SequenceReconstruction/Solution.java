class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();
        for(List<Integer> seq: seqs){
            if(seq.size() == 1){
                if(!map.containsKey(seq.get(0))){
                    map.put(seq.get(0), new HashSet<>());
                }
                if(!degree.containsKey(seq.get(0))){
                    degree.put(seq.get(0), 0);
                }
            }
            else{
                for(int i = 0; i < seq.size() - 1; i++){
                    int cur = seq.get(i);
                    int next = seq.get(i + 1);
                    if(!map.containsKey(cur)){
                        map.put(cur, new HashSet<>());
                    }
                    if(!map.containsKey(next)){
                        map.put(next, new HashSet<>());
                    }
                    if(!degree.containsKey(cur)){
                        degree.put(cur, 0);
                    }
                    if(!degree.containsKey(next)){
                        degree.put(next, 0);
                    }
                    int indegree = degree.get(next);
                    Set<Integer> set = map.get(cur);
                    if(!set.contains(next)){
                        indegree++;
                        degree.put(next, indegree);
                        set.add(next);
                    }
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int key: degree.keySet()){
            if(degree.get(key) == 0){
                queue.offer(key);
            }
        }
        int index = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            if(size > 1) return false;
            for(int i = 0; i < size; i++){
                int cur = queue.poll();
                if(index == org.length || org[index] != cur) return false;
                for(int neighbor: map.get(cur)){
                    int indegree = degree.get(neighbor);
                    indegree--;
                    if(indegree == 0){
                        queue.offer(neighbor);
                    }
                    degree.put(neighbor, indegree);
                }
                index++;
            }
        }
        return index == org.length && index == map.size();
    }
}
