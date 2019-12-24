class Solution {
    public int longestOnes(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        while(end < A.length){
            int cur = A[end];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            while(map.getOrDefault(0, 0) > K){
                int begin = A[start];
                if(begin == 0){
                    map.put(0, map.get(0) - 1);
                }
                start++;
            }
            max = Math.max(max, end - start + 1);
            end++;           
        }
        return max;
    }
}
