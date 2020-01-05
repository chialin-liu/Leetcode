class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int []res = new int[nums.length];
        for(int i = 0; i < res.length; i++){
            res[i] = -1;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < 2 * nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]){
                res[stack.pop()] = nums[i % nums.length];
            }
            if(i < nums.length){
                stack.push(i);
            }
        }
        return res;
    }
}
