class Solution {
    public int findLongestChain(int[][] pairs) {
     Arrays.sort(pairs, new Comparator<int []>(){
         public int compare(int []a, int []b){
             return a[0] - b[0];
         }
     });   
        int []dp = new int [pairs.length];
        for(int i = 0; i < pairs.length; i++){
            dp[i] = 1;
        }
        for(int i = 0; i < pairs.length; i++){
            for(int j = 0; j < i; j++){
                if(pairs[i][0] > pairs[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[pairs.length - 1];
    }
}
