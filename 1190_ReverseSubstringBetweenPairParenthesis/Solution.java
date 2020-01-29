class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for(char cur: s.toCharArray()){
            if(cur == ')'){
                Queue<Character> queue = new LinkedList<>();
                while(!stack.isEmpty() && stack.peek() != '('){
                    queue.offer(stack.pop());
                }
                stack.pop();
                while(!queue.isEmpty()){
                    stack.push(queue.poll());
                }
            }
            else{
                stack.push(cur);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
