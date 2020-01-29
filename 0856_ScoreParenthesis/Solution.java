class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        int total = 0;
        int num = 0;
        int before = 0;
        for(char cur: S.toCharArray()){
            if(cur == '('){
                stack.push(cur);
            }
            else if(cur == ')'){
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() != '('){
                    char tmp = stack.pop();
                    sb.insert(0, tmp);
                }
                stack.pop();
                StringBuilder sb2 = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() != '('){
                    char tmp = stack.pop();
                    sb2.insert(0, tmp);
                }
                before = sb2.length() != 0? Integer.valueOf(sb2.toString()): 0;
                if(sb.length() != 0){
                    num = Integer.valueOf(sb.toString());
                    num = num * 2;
                }
                else{
                    num = 1;
                }
                num += before;
                String str = String.valueOf(num);
                for(char digit: str.toCharArray()){
                    stack.push(digit);
                }
                
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.insert(0, stack.pop());
        }
        return Integer.valueOf(ans.toString());
    }
}
