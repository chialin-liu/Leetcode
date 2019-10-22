class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if((s.charAt(i) != ')') && (s.charAt(i) != ']') && (s.charAt(i) != '}')){
                stack.push(s.charAt(i));
            }
            else{
                if(!stack.isEmpty()){
                    Character cur = stack.peek();
                    if((cur == '(') && (s.charAt(i) == ')')){
                        stack.pop();
                    }
                    else if((cur == '[') && (s.charAt(i) == ']')){
                        stack.pop();
                    }
                    else if((cur == '{') && (s.charAt(i) == '}')){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
        if(stack.size() > 0) return false;
        else return true;
    }
}
