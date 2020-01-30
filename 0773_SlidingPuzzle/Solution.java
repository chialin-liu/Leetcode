class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder start = new StringBuilder();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                start.append(String.valueOf(board[i][j]));
            }
        }
        String startStr = start.toString();
        int [][]dist = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        Queue<String> queue = new LinkedList<>();
        queue.offer(startStr);
        Set<String> set = new HashSet<>();
        set.add(startStr);
        int step = 0;
        int startIndex = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.poll();
                if(cur.equals(target)){
                    return step;
                }
                for(int j = 0; j < cur.length(); j++){
                    if(cur.charAt(j) == '0'){
                        startIndex = j;
                    }
                }
                for(int dir: dist[startIndex]){
                    String newStr = change(cur, dir, startIndex);
                    if(!set.contains(newStr)){
                        queue.offer(newStr);
                        set.add(newStr);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    public String change(String cur, int index, int start){
        StringBuilder sb = new StringBuilder(cur);
        sb.setCharAt(index, cur.charAt(start));
        sb.setCharAt(start, cur.charAt(index));
        return sb.toString();
    }
}
