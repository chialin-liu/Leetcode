class Solution {
    public int minIncrementForUnique(int[] A) {
        int res = 0;
        int need = 0;
        Arrays.sort(A);
        for(int a: A){
            res += Math.max(need - a, 0);
            need = Math.max(a, need) + 1;
        }
        return res;
    }
}
