class Pair{
    int number;
    int step;
    Pair(int n, int s){
        number = n;
        step = s;
    }
}
class Solution {
    
    public int numSquares(int n) {
        if(n == 0) return 0;
        Pair cur = new Pair(n, 0);
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(cur);
        boolean []visit = new boolean[n + 1];
        visit[n] = true;
        while(!queue.isEmpty()){
            Pair now = queue.poll();
            if(now.number == 0){
                return now.step;
            }
            for(int i = 1; now.number - i * i >= 0; i++){
                int newNumber = now.number - i * i;
                int newStep = now.step + 1;
                if(!visit[newNumber]){
                    queue.offer(new Pair(newNumber, newStep));
                    visit[newNumber] = true;
                }
                
            }
        }
        return -1;
    }
}
