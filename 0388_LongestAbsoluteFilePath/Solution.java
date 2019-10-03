class Solution {
    public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0) return 0;
        String [] str = input.split("\n");
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int maxLen = 0;
        for(int i = 0; i < str.length; i++){
            int numOfTab = str[i].lastIndexOf("\t") + 1;
            int level = numOfTab + 1;
            while(level < stack.size()){
                stack.pop();
            } 
            
            int curLen = stack.peek() + str[i].length() - numOfTab + 1;
            if(str[i].contains(".")) {
                maxLen = Math.max(curLen - 1, maxLen);
            }
            stack.push(curLen);
        }
        return maxLen;
    }
}
