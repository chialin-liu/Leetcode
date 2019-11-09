class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        int [] res = new int [n];
        res[0] = 1;
        for(int i = 1; i < n; i++){
            res[i] = i * res[i - 1];
        }
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for(int i = n; i > 0; i--){
            int index = k / res[i - 1];
            k = k % res[i - 1];
            sb.append(list.get(index));
            list.remove(list.get(index));
        }
        return sb.toString();
    }
}
