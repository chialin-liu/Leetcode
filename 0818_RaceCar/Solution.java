class Solution {
    public int racecar(int target) {
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[]{0, 1});
        Set<String> visited = new HashSet<>();
        String str = String.valueOf(0) + "+" + String.valueOf(1);
        visited.add(str);
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int []cur = queue.poll();
                if(cur[0] == target){
                    return step;
                }
                int []next = new int[]{cur[0] + cur[1], cur[1] * 2};
                String newStr = String.valueOf(next[0]) + "+" + String.valueOf(next[1]);
                if(!visited.contains(newStr) && next[0] > 0 && next[0] < 2 * target){
                    queue.offer(next);
                    visited.add(newStr);
                }
                
                int []revNext = new int[]{cur[0], cur[1] > 0? -1: 1};
                 newStr = String.valueOf(revNext[0]) + "+" + String.valueOf(revNext[1]);
                if(!visited.contains(newStr) && revNext[0] > 0 && revNext[0] < 2 * target){
                    queue.offer(revNext);
                    visited.add(newStr);
                }
            }
            step++;
        }
        return -1;
    }
}
