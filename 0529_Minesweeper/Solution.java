class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int []{click[0], click[1]});
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int []cur = queue.poll();
                if(board[cur[0]][cur[1]] == 'M'){
                    board[cur[0]][cur[1]] = 'X';
                    return board;
                }
                else{
                    int count = 0;
                    for(int row = -1; row < 2; row++){
                        for(int col = -1; col < 2; col++){
                            if(row == 0 && col == 0) continue;
                            int newX = row + cur[0];
                            int newY = col + cur[1];
                            if(newX >= 0 && newY >= 0 && newX < board.length && newY < board[0].length){
                                if(board[newX][newY] == 'M'){
                                    count++;
                                }  
                            }
                            
                        }
                    }
                    if(count > 0){
                        board[cur[0]][cur[1]] = (char) (count + '0');
                    }
                    else{
                        board[cur[0]][cur[1]] = 'B';
                        for(int row = -1; row < 2; row++){
                            for(int col = -1; col < 2; col++){
                                if(row == 0 && col == 0) continue;
                                int newX = row + cur[0];
                                int newY = col + cur[1];
                                if(newX >= 0 && newY >= 0 && newX < board.length && newY < board[0].length && board[newX][newY] == 'E'){
                                    queue.offer(new int[]{newX, newY});
                                    board[newX][newY] = 'B';
                                     
                                }
                            }
                        }
                    }
                }
            }
        }
        return board;
    }
}
