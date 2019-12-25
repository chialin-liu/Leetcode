class Solution {
    public String removeDuplicates(String S) {
        if(S == null || S.length() == 0) return S;
        Stack<Character> stack = new Stack<>();
        for(char cur: S.toCharArray()){
            if(!stack.isEmpty() && stack.peek() != cur){
                stack.push(cur);
            }
            else if(!stack.isEmpty() && stack.peek() == cur){
                stack.pop();
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
