class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        char []s = S.toCharArray();
        char []t = T.toCharArray();
        for(char cur: s){
            if(cur == '#'){
                if(!stackS.isEmpty()) stackS.pop();
            }
            else{
                stackS.push(cur);
            }
        }
        for(char cur: t){
            if(cur == '#'){
                if(!stackT.isEmpty()) stackT.pop();
            }
            else{
                stackT.push(cur);
            }
        }
        while(!stackS.isEmpty() && !stackT.isEmpty()){
            if(stackS.peek() == stackT.peek()){
                stackS.pop();
                stackT.pop();
            }
            else{
                return false;
            }
        }
        if(!stackS.isEmpty() || !stackT.isEmpty()){
            return false;
        }
        return true;
        
    }
}
