class Solution {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);
        int res = 0;
        for(int i = 0; i < A.length; i++){
            sum += A[i];
            if(K != 0){
                sum = sum % K;
            }
            if(sum < 0) sum += K;
            if(map.containsKey(sum)){
                res += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
