class Solution {
    public int findLength(int[] A, int[] B) {
        int start = 0;
        int end = Math.min(A.length, B.length);
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(isLengthValid(A, B, mid)){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(isLengthValid(A, B, end)){
            return end;
        }
        else{
            return start;
        }
    }
    public boolean isLengthValid(int []A, int []B, int length){
        Set<String> set = new HashSet<>();
        for(int i = 0; i + (length - 1) < A.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < length; j++){
                sb.append(A[i + j]);
            }
            set.add(sb.toString());
        }
        for(int i = 0; i + (length - 1) < B.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < length; j++){
                sb.append(B[i + j]);
            }
            if(set.contains(sb.toString())){
                return true;
            }
        }
        return false;
    }
}
