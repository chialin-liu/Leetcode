class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    public MedianFinder() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(max.size() == 0 || num < max.peek()){
            max.offer(num);
        }
        else{
            min.offer(num);
        }
        balance();
    }
    
    public double findMedian() {
        
        double res;
        if(max.size() == min.size()){
            res = ((double)max.peek() + (double)min.peek()) / 2;
            return res;
        } 
        else {
            return max.peek();
            
        }     
    }
    public void balance(){
        while(max.size() < min.size()){
            max.offer(min.poll());
        }
        while(min.size() < max.size() - 1){
            min.offer(max.poll());
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
