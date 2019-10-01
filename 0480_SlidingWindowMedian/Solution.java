class Solution {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int resLen = n - (k - 1);
        double [] res = new double[resLen];
        if(nums == null || nums.length == 0) return res;
        max = new PriorityQueue<>(n, Collections.reverseOrder());
        min = new PriorityQueue<>(n);
        
        for(int i = 0; i < n; i++){
            if(max.size() == 0 || nums[i] <= max.peek()){
                max.offer(nums[i]);
            }
            else{
                min.offer(nums[i]);
            }
            balance();
            if(i >= k){
                if(nums[i - k] > max.peek()){
                    min.remove(nums[i - k]);
                }
                else{
                    max.remove(nums[i - k]);
                }
            }
            balance();
            if(i >= k - 1){
                if(k % 2 == 1){
                    res[i - (k - 1)] = max.peek();
                }
                else{
                    res[i - (k - 1)] = ((double)max.peek() + (double)min.peek()) / 2;
                }
            }
        }
        return res;              
    }
    private void balance(){
        while(max.size() < min.size()){
            max.offer(min.poll());
        }
        while(min.size() < max.size() - 1){
            min.offer(max.poll());
        }
    }
}
