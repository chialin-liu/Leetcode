class Solution {
    public int videoStitching(int[][] clips, int T) {
        int st = 0;
        int end = 0;
        int res = 0;
        int start = 0;
        Arrays.sort(clips, new Comparator<int []>(){
           public int compare(int []a, int []b){
               return a[0] - b[0];
           } 
        });
        st = 0;
        // res = 0;
        while(st < T){
            
            for(; start < clips.length; start++){
                if(clips[start][0] <= st){
                    end = Math.max(end, clips[start][1]);
                }
                else{
                    break;
                }
            }
            if(st == end){
                return -1;
            }
            else{
                st = end;
            }
            res++;
        }
        return res;
    }
}
