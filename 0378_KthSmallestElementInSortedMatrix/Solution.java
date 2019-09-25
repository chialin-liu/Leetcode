public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
     */
     class Pair{
         public int x;
         public int y;
         public int val;
         Pair(int a, int b, int value){
             this.x = a;
             this.y = b;
             this.val = value;
         }
     }
     class PairComparator implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return a.val - b.val;
    }
}
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int [] dx = {0 , 1};
        int [] dy = {1 , 0};
        int m = matrix[0].length;
        int n = matrix.length;
        boolean [][]hash = new boolean[n][m];
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(k, new PairComparator());
        queue.offer(new Pair(0, 0, matrix[0][0]));
        hash[0][0] = true;
        int count = 0;
        for(int i = 0; i < k - 1; i++){
            Pair cur = queue.poll();
            Pair newP = new Pair(0, 0, 0);
            for(int j = 0; j < 2; j++){
                newP.x = cur.x + dx[j];
                newP.y = cur.y + dy[j];
                if(newP.x < m && newP.y < n && hash[newP.y][newP.x] == false){
                    hash[newP.y][newP.x] = true;
                    queue.offer(new Pair(newP.x, newP.y, matrix[newP.y][newP.x]));
                }
                
            }
        }
        return queue.peek().val;
        
    }
}
