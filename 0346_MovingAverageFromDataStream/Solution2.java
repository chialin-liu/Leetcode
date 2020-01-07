class MovingAverage {

    /** Initialize your data structure here. */
    Queue<Integer> queue;
    double sum;
    double avg;
    int globalSize;
    public MovingAverage(int size) {
        sum = 0;
        avg = 0;
        globalSize = size;
        queue = new LinkedList<>();
    }
    
    public double next(int val) {
        if(queue.size() < globalSize){
            queue.offer(val);
            sum += val;
        }
        else{
            sum = avg * globalSize;
            int remove = queue.poll();
            sum -= (double) remove;
            queue.offer(val);
            sum += (double) val;
        }
        avg = sum / queue.size();
        return avg;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
