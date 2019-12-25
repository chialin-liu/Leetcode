class Solution {
    class Point{
        int count;
        char alphabet;
        public Point(int c, char cur){
            this.count = c;
            this.alphabet = cur;
        }
    }
    public String removeDuplicates(String s, int k) {
        if(s == null || s.length() == 0) return s;
        Stack<Point> stack = new Stack<>();
        for(char cur: s.toCharArray()){
            if(!stack.isEmpty()){
                Point top = stack.peek();
                if(top.alphabet == cur && top.count + 1 < k){
                    Point newP = new Point(top.count + 1, cur);
                    stack.push(newP);
                }
                else if(top.alphabet == cur && top.count + 1 == k){
                    for(int i = 0; i < k - 1; i++){
                        stack.pop();
                    }
                }
                else{
                    Point newP = new Point(1, cur);
                    stack.push(newP);
                }
            }
            else{
                Point newP = new Point(1, cur);
                stack.push(newP);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop().alphabet);
        }
        return sb.reverse().toString();
    }
}
