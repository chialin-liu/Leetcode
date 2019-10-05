import java.util.Stack;

class Solution {
  public int calculate(String s) {
    if(s == null || s.length() == 0) return 0;
    Stack<Integer> stack = new Stack<>();
    Stack<Character> op = new Stack<>();
    char [] c = s.toCharArray();
    for(int i = 0; i < s.length(); i++){
      if(c[i] == ' ') continue;
      if(Character.isDigit(c[i])){
        int num = c[i] - '0';
        while(i + 1 < s.length() && Character.isDigit(c[i + 1])){
          num = num * 10 + c[i + 1] - '0';
          i++;
        }
        stack.push(num);
        num = 0;
      }
      else if(c[i] == '('){
        op.push(c[i]);
      }
      else if(c[i] == ')'){
        while(!op.isEmpty() && op.peek() != '('){
          int b =  stack.isEmpty()? 0:stack.pop();
          Character operator = op.pop();
//          int a =  op.peek() == '(' || stack.isEmpty()? 0:stack.pop();
          int a =   stack.isEmpty()? 0:stack.pop();

          int res = operation(a, b, operator);
          stack.push(res);
        }
        op.pop();
      }
      else{

        while(!op.isEmpty() && priority(op.peek(), c[i])){
          int b = stack.isEmpty()? 0:stack.pop();
          int a = stack.isEmpty()? 0:stack.pop();
          Character operator = op.pop();
          int res = operation(a, b, operator);
          stack.push(res);
        }
        if(c[i] == '-'){
          int idx = i - 1;
          while(idx >= 0 && c[idx] == ' '){
            idx--;
          }
          if(idx >= 0 && c[idx] == '('){
            stack.push(0);
          }
        }
        op.push(c[i]);
      }
    }
    while(!op.isEmpty()){
      int b = stack.isEmpty()? 0:stack.pop();
      int a = stack.isEmpty()? 0:stack.pop();
      Character operator = op.pop();
      int res = operation(a, b, operator);
      stack.push(res);
    }
    return stack.isEmpty()? 0 : stack.pop();

  }
  public boolean priority(Character stackTop, Character cur){
    if(stackTop == '(' || stackTop == ')') return false;
    else if( (stackTop == '+' || stackTop == '-') && (cur == '*' || cur == '/') ) return false;
    else{
      return true;
    }
  }
  public int operation(int a, int b, Character operator){
    int res = 0;
    if(operator == '+') res = a + b;
    else if(operator == '-') res = a - b;
    else if(operator == '*') res = a * b;
    else if(operator == '/') res = a / b;
    return res;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
//    String str = "2*(5+5*2)/3+(6/2+8)";
    String str = "1-(-1)";

    int res = sol.calculate(str);
    System.out.println(res);
  }
}
