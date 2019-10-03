class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        char [] c = s.toCharArray();
        int res = 0;
        int num = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(c[i])){
                num = c[i] - '0';
                while(i + 1 < s.length() && Character.isDigit(c[i + 1])){
                    num = num * 10 + c[i + 1] - '0';
                    i++;
                }
            }
            if(!Character.isDigit(c[i]) && c[i] != ' ' || i == s.length() - 1){
                if(sign == '+') stack.push(num);
                else if(sign == '-') stack.push(-num);
                else if(sign == '*'){
                    stack.push(stack.pop() * num);
                }
                else if(sign == '/'){
                    stack.push(stack.pop() / num);
                }
                sign = c[i];
                num = 0;
            }
        }
        for(int i : stack){
            res = res + i;
        }
        return res;
    }
}
