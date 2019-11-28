class NumArray {
    int []nums;
    int []tree;
    public NumArray(int[] nums) {
        this.tree = new int[nums.length + 1];
        this.nums = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            update(i, nums[i]);
        }
        
    }
    public void update(int i, int val){
        int diff = val - nums[i];
        nums[i] = val;
        for(int k = i + 1; k < tree.length; k += (k & (-k))){
            tree[k] += diff;
        }
    }
    public int sumRange(int i, int j) {
        return getSum(j + 1) - getSum(i);
    }
    public int getSum(int i){
        int sum = 0;
        for(int k = i; k > 0; k -= (k & (-k))){
            sum += tree[k];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
