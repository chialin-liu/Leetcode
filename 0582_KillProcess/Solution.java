class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int num: pid){
            map.put(num, new HashSet<Integer>());
        }
        for(int i = 0; i < pid.size(); i++){
            if(map.containsKey(ppid.get(i))){
                Set<Integer> set = map.get(ppid.get(i));
                set.add(pid.get(i));
            }
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while(!queue.isEmpty()){
            int parent = queue.poll();
            res.add(parent);
            for(int num: map.get(parent)){
                queue.offer(num);
            }
        }
        return res;
    }
}
