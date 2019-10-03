class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int res = 0;
        int sign = 1;
        char [] c = s.toCharArray();
        for(int i = 0; i < c.length; i++){
            if(Character.isDigit(c[i])){
                num = c[i] - '0';
                while(i + 1 < c.length && Character.isDigit(c[i + 1])){
                    num = num * 10 + c[i + 1] - '0';
                    i++;
                }
                res = res + num * sign;
            }
            else if(c[i] == '+'){
                sign = 1;
            }
            else if(c[i] == '-'){
                sign = -1;
            }
            else if(c[i] == '('){
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }
            else if(c[i] == ')'){
                res = stack.pop() * res + stack.pop();
            }
        }
        return res;
    }
}
