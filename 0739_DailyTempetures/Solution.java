class Solution {
    class Pair{
        int temp;
        int index;
        public Pair(int t, int index){
            this.temp = t;
            this.index = index;
        }
    }
    public int[] dailyTemperatures(int[] T) {
        Stack<Pair> stack = new Stack<>();
        if(T == null || T.length == 0) return new int[]{};
        int []res = new int [T.length];
        stack.push(new Pair(T[0], 0));
        for(int i = 1; i < T.length; i++){
            while(!stack.isEmpty() && stack.peek().temp < T[i]){
                Pair cur = stack.pop();
                res[cur.index] = i - cur.index;
            }
            stack.push(new Pair(T[i], i));
        }
        return res;
    }
}
