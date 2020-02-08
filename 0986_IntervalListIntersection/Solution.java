class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int indexA = 0;
        int indexB = 0;
        int m = A.length;
        int n = B.length;
        List<List<Integer>> res = new ArrayList<>();
        while(indexA < m && indexB < n){
            int startMax = Math.max(A[indexA][0], B[indexB][0]);
            int endMin = Math.min(A[indexA][1], B[indexB][1]);
            List<Integer> tmp = new ArrayList<>();
            if(startMax <= endMin){
                tmp.add(startMax);
                tmp.add(endMin);
                res.add(tmp);                
            }
            
            if(A[indexA][1] == endMin) indexA++;
            if(B[indexB][1] == endMin) indexB++;
        }
        int [][]ans = new int[res.size()][2];
        int index = 0;
        for(List<Integer> tmp: res){
            ans[index][0] = tmp.get(0);
            ans[index][1] = tmp.get(1);
            index++;
        }
        return ans;
    }
}
