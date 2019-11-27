class Solution {
Random rnd;
    int []sum;
    public Solution(int[] w) {
        this.rnd = new Random();
        this.sum = w;
        sum[0] = w[0];
        for(int i = 1; i < w.length; i++){
            sum[i] = sum[i - 1] + w[i];
        }
        
    }
    
    public int pickIndex() {
        int target = rnd.nextInt(sum[sum.length - 1]) + 1;
        int left = 0;
        int right = sum.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(sum[mid] == target){
                return mid;
            }
            else if(sum[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
