class Ugly{
    int [] arr = new int [1690]; 
    Ugly(){
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        Long num = 1L;
        set.add(num);
        queue.offer(num);
        long [] nums = new long[]{2, 3, 5};
        for(int i = 0; i < arr.length; i++){
            long cur = queue.poll();
            arr[i] = (int) cur;
            for(int j = 0; j < nums.length; j++){
                long prime = nums[j] * cur;
                if(!set.contains(prime)){
                    queue.offer(prime);
                    set.add(prime);
                }
            }

        }
    }
    public int getValue(int n){
        return arr[n - 1];
    }
}
class Solution {
    public int nthUglyNumber(int n) {
        Ugly ugly = new Ugly();
        return ugly.getValue(n);
    }
}
