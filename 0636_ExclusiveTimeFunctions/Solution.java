class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int []res = new int[n];
        int pre = 0;
        for(String log: logs){
            String []arr = log.split(":");
            if(arr[1].equals("start")){
                if(!stack.isEmpty()){
                    res[stack.peek()] += Integer.valueOf(arr[2]) - pre;
                }
                pre = Integer.valueOf(arr[2]);
                stack.push(Integer.valueOf(arr[0]));
            }
            else{
                res[stack.pop()] += Integer.valueOf(arr[2]) - pre + 1;
                pre = Integer.valueOf(arr[2]) + 1;
            }
        }
        return res;
    }
}
