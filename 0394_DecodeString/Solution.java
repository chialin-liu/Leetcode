class Solution {
    public String decodeString(String s) {
        Stack<Object> stack = new Stack<>();
        int number = 0;
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                number = number * 10 + (c - '0');
            }
            else{
                if(c == '['){
                    stack.push(Integer.valueOf(number));
                    number = 0;
                }
                else if(c == ']'){
                    String newStr = popStack(stack);
                    Integer count = (Integer) stack.pop();
                    for(int i = 0; i < count; i++){
                        stack.push(newStr);
                    }
                }
                else{
                    stack.push(String.valueOf(c));
                }
            }
        }
        return popStack(stack);        
    }
    public String popStack(Stack<Object> stack){
        Stack<String> stack2 = new Stack<>();
        while(!stack.isEmpty() && stack.peek() instanceof String){
            stack2.push((String) stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!stack2.isEmpty()){
            sb.append(stack2.pop());
        }
        return sb.toString();
    }
}
