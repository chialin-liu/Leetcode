class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(String op: ops){
            if(op.equals("C")){
                sum -= stack.pop();
            }
            else if(op.equals("D")){
                int multi = stack.peek() * 2;
                sum += multi;
                stack.push(multi);
            }
            else if(op.equals("+")){
                int temp = stack.pop();
                int total = stack.peek() + temp;
                stack.push(temp);
                stack.push(total);
                sum += total;
            }
            else{
                stack.push(Integer.valueOf(op));
                sum += Integer.valueOf(op);
            }
        }
        return sum;
    }
}
