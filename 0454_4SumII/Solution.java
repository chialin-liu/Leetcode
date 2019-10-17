class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a: A){
            for(int b: B){
                int sum = a + b;
                if(map.containsKey(sum)){
                    int val = map.get(sum);
                    val++;
                    map.put(sum, val);
                }
                else{
                    map.put(sum, 1);
                }
            }
        }
        int res = 0;
        for(int c: C){
            for(int d: D){
                int sum = -c - d;
                if(map.containsKey(sum)){
                    res = res + map.get(sum);
                }
            }
        }
        return res;
    }
}
