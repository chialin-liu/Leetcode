class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int [] bucket = new int [n + 1];
        for(int i = 0; i < citations.length; i++){
            if(citations[i] >= n){
                bucket[n]++;
            }
            else{
                bucket[citations[i]]++;
            }
        }
        int count = 0;
        for(int i = n; i >= 0; i--){
            count += bucket[i];
            if(count >= i){
                return i;
            }
                
            
        }
        return 0;
    }
}
