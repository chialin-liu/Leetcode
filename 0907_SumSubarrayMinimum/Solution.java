class Solution {
    public int sumSubarrayMins(int[] A) {
        Stack<int []> stack = new Stack<>();
        int []left = new int[A.length];
        int []right = new int[A.length];
        for(int i = 0; i < A.length; i++){
            left[i] = i + 1;
            right[i] = A.length - i;
        }
        for(int i = 0; i < A.length; i++){
            while(!stack.isEmpty() && stack.peek()[0] > A[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty()? i + 1: i - stack.peek()[1];
            stack.push(new int[]{A[i], i});
        }
        stack = new Stack<>();
        for(int i = 0; i < A.length; i++){
            while(!stack.isEmpty() && stack.peek()[0] > A[i]){
                right[stack.peek()[1]] = i - stack.peek()[1];
                stack.pop();
            }
            stack.push(new int[]{A[i], i});
        }
        int ans = 0;
        int mod = 1000000000 + 7;
        for(int i = 0; i < A.length; i++){
            ans = (ans + A[i] * left[i] * right[i]) % mod;
        }
        return ans;
    }
}
