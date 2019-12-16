class Solution {
    public int findKthNumber(int m, int n, int k) {
        int start = 1;
        int end = m * n;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            int count = getcount(mid, m, n);
            if(count >= k){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(getcount(start, m, n) == k){
            return start;
        }
        else{
            return end;
        }
    }
    public int getcount(int mid, int m, int n){
        int count = 0;
        for(int i = 1; i <= m; i++){
            int temp = Math.min(mid / i, n);
            count += temp;
        }
        return count;
    }
}
