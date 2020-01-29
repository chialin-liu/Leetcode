class Solution {
    public String removeOuterParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        char []arr = S.toCharArray();
        int check = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '('){
                stack.push(i);
                if(stack.size() > 1){
                    sb.append("(");
                }
            }
            else if(arr[i] == ')'){
                stack.pop();
                if(!stack.isEmpty()){
                    sb.append(")");
                }
            }
            
        }
        return sb.toString();
    }
}
