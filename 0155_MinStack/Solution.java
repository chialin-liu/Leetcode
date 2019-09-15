class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        // do intialization if necessary
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        stack.push(number);
        if(minStack.isEmpty()){
            minStack.push(number);
        }
        else{
            minStack.push(Math.min(number, minStack.peek()));
        }
    }

    /*
     * @return: An integer
     */
    public void pop() {
        // write your code here
        minStack.pop();
        stack.pop();
    }

    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
