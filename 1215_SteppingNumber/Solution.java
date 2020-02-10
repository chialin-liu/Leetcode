class Solution {
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> res = new ArrayList<>();
        Queue<Long> queue = new LinkedList<>();
        for(int i = 1; i <= 9; i++){
            
                queue.offer((long)i);
            
        }
        if(low == 0) res.add(0);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                long cur = queue.poll();
                long last = cur % 10;
                if(cur < high){
                    if(last > 0){
                        queue.offer(cur * 10 + last - 1);
                    }
                    if(last < 9){
                        queue.offer(cur * 10 + last + 1);
                    }
                }
                if(cur >= low && cur <= high){
                    res.add((int)cur);
                }
            }
        }
        return res;
    }
}
