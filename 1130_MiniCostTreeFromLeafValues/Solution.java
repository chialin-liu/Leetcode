class Solution {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int res = 0;
        for(int a: arr){
            while(stack.peek() <= a){
                int mid = stack.pop();
                res += mid * Math.min(a, stack.peek());
            }
            stack.push(a);
        }
        while(stack.size() > 2){
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}
