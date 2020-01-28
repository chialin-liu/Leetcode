class Solution {
    public String removeKdigits(String num, int k) {
        int []arr = new int[num.length()];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < num.length(); i++){
            int val = num.charAt(i) - '0';
            while(k > 0 && !stack.isEmpty() && val < stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(val);
        }
        while(k > 0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }
        if(stack.size() == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            String str = String.valueOf(stack.pop());
            sb.append(str);
        }
        String str = sb.reverse().toString();
        while(str.length() > 0 && str.charAt(0) == '0'){
            str = str.substring(1, str.length());
        }
        return str.length() > 0? str: "0";
    }
}
