class Solution {
    public String smallestSubsequence(String text) {
        Stack<Character> stack = new Stack<>();
        int []last = new int[26];
        int []seen = new int[26];
        for(int i = 0; i < text.length(); i++){
            last[text.charAt(i) - 'a'] = i;
        }
        for(int i = 0; i < text.length(); i++){
            char cur = text.charAt(i);
            if(seen[cur - 'a'] > 0) continue;
            else{
                seen[cur - 'a'] = 1;
            }
            while(!stack.isEmpty() && stack.peek() > cur && i < last[stack.peek() - 'a']){
                char delete = stack.pop();
                seen[delete - 'a'] = 0;
            }
            stack.push(cur);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
