class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num : nums){
            queue.offer(num);
            while(queue.size() > k){
                queue.poll();
            }
        }
        return queue.poll();        
    }
}
