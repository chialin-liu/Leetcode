class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        double [][]workers = new double[quality.length][2];
        for(int i = 0; i < quality.length; i++){
            workers[i][0] = (double) wage[i] / quality[i];
            workers[i][1] = quality[i];
        }
        Arrays.sort(workers, new Comparator<double []>(){
            public int compare(double []a, double []b){
                return Double.compare(a[0], b[0]);
            }
            
        });
        PriorityQueue<double []> queue = new PriorityQueue<>(new Comparator<double []>(){
            public int compare(double []a, double []b){
                return (int)b[1] - (int)a[1];
            }
        });
        double qualitySum = 0;
        double min = Double.MAX_VALUE;
        for(double []worker: workers){
            qualitySum += worker[1];
            queue.offer(worker);
            if(queue.size() > K){
                qualitySum -= queue.poll()[1];
            }
            if(queue.size() == K){
                min = Math.min(min, qualitySum * worker[0]);
            }
        }
        return min;
        
    }
}
