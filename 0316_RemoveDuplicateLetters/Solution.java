class Solution {
    public String removeDuplicateLetters(String s) {
        boolean []visited = new boolean[26];
        int []count = new int [26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            count[cur - 'a']--;
            if(visited[cur - 'a'] == true) continue;
            while(!stack.isEmpty() && cur < stack.peek() && count[stack.peek() - 'a'] != 0){
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(cur);
            visited[cur - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
