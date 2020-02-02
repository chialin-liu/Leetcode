class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        for(int stone: stones){
            queue.offer(stone);
        }
        while(queue.size() > 1){
            int num = queue.poll();
            int num2 = queue.poll();
            if(num != num2){
                queue.offer(Math.abs(num - num2));
            }
        }
        return queue.size() == 1? queue.peek(): 0;
    }
}
