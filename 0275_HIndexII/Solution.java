class Solution {
    public int hIndex(int[] citations) {
        int start = 0;
        if(citations.length == 0 || citations == null) return 0;
        int end = citations.length - 1;
        int len = citations.length;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(citations[mid] == len - mid){
                // return mid;
                end = mid;
            }
            else if(citations[mid] > len - mid){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(citations[start] >= len - start){
            return len - start;
        }
        else if(citations[end] >= len - end){
            return len - end;
        }
        else{
            return 0;
        }
    }
}
