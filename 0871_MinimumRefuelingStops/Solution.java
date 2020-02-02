class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        int res = 0;
        int i = 0;
        while(startFuel < target){
            while(i < stations.length && startFuel >= stations[i][0]){
                queue.offer(stations[i][1]);
                i++;
            }
            if(queue.isEmpty()){
                return -1;
            }
            startFuel += queue.poll();
            res++;
        }
        return res;
    }
}
