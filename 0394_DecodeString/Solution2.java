import java.util.Stack;

class Solution {
  public String decodeString(String s) {
    if(s == null || s.length() == 0) return s;
    Stack<Object> stack = new Stack<>();
    Stack<String> stack2 = new Stack<>();
//    char [] c = s.toCharArray();
    int val = 0;
    for(int i = 0; i < s.length(); i++){
      if(Character.isDigit(s.charAt(i))){
        val = s.charAt(i) - '0';
        while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){
          val = val * 10 + s.charAt(i + 1) - '0';
          i++;
        }
        stack.push(Integer.valueOf( val ));
        val = 0;
      }
      else if(s.charAt(i) == '['){
        stack.push(String.valueOf(s.charAt(i)));
      }
      else if(s.charAt(i) == ']'){
        while( !stack.peek().equals("[")){
          String tmp =  (String)stack.pop();
          stack2.push((String) tmp);
        }
        stack.pop(); //remove "["
        int count = (Integer) stack.pop();
        StringBuilder sb = new StringBuilder();
        while(!stack2.isEmpty()){
          sb.append(stack2.pop());
        }
        String newStr = sb.toString();
        for(int ii = 0; ii < count; ii++){
          stack.push(newStr);
        }
      }
      else{
        stack.push( String.valueOf(s.charAt(i)));
      }
    }
    StringBuilder res = new StringBuilder();
    Stack<String> stack3 = new Stack<>();
    while(!stack.isEmpty()){
      stack3.push((String) stack.pop());
    }
    while(!stack3.isEmpty()){
      res.append(stack3.pop());
    }
    return res.toString();
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    String s = "3[a2[c]]";
    String res = sol.decodeString(s);
    System.out.println(res);
  }
}
