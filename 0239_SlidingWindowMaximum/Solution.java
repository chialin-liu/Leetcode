class Solution {
    int []a;
    public void inQueue(Deque<Integer> deque, int pos){
        while(!deque.isEmpty() && a[deque.peekLast()] <= a[pos]){
            deque.pollLast();
        }
        deque.offer(pos);
    }
    public void outQueue(Deque<Integer> deque, int pos){
        if(deque.peekFirst() == pos){
            deque.pollFirst();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        a = nums;
        Deque<Integer> deque = new ArrayDeque<>();
        int [] res = new int [nums.length - k + 1];
        if(nums == null || nums.length == 0) return nums;
        for(int i = 0; i < k; i++){
            inQueue(deque, i);
        }
        int idx = 0;
        for(int i = k; i < nums.length; i++){
            res[idx] = a[deque.peekFirst()];
            idx++;
            outQueue(deque, i - k);
            inQueue(deque, i);
        }
        res[idx] = a[deque.peekFirst()];
        return res;
    }
}
