class Solution {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        int max = Math.max(stones[n - 1] - stones[1] + 2 - n, stones[n - 2] - stones[0] + 2 - n);
        int min = Integer.MAX_VALUE;
        for(int i = 0, j = 0; j < n; j++){
            while(stones[j] - stones[i] + 1 > n){
                i++;
            }
            int already = j - i + 1;
            if(stones[j] - stones[i] + 1 == n - 1 && j - i + 1 == n - 1){
                min = Math.min(min, 2);
            }
            else{
                min = Math.min(min, n - already);
            }
        }
        return new int []{min, max};
    }
}
