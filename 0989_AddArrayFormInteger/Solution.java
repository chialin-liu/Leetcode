class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {

        List<Integer> res = new ArrayList<>();
        int sum = 0;
        int carry = 0;
        int k = K;
        for(int i = A.length - 1; i >= 0 || sum > 0 || k > 0; i--, k = k / 10){
            int d1 = (i >= 0)? A[i]: 0;
            int d2 = k % 10;
            sum = d1 + d2 + sum;
            res.add(sum % 10);
            sum = sum / 10;
        }
        Collections.reverse(res);
        return res;
    }
}
