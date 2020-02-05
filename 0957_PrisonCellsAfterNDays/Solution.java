class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Set<String> set = new HashSet<>();
        // set.add(Arrays.toString(cells));
        boolean hasCycle = false;
        int cycle = 0;
        for(int i = 0; i < N; i++){
            int []next = new int[8];
            for(int j = 1; j < 7; j++){
                next[j] = (cells[j - 1] == cells[j + 1])? 1: 0;
            }
            if(set.contains(Arrays.toString(next))){
                hasCycle = true;
                break;
            }
            else{
                cycle++;
                set.add(Arrays.toString(next));
            }
            cells = next;
        }
        if(hasCycle){
            N = N % cycle;
            for(int i = 0; i < N; i++){
                int []next = new int[8];
                for(int j = 1; j < 7; j++){
                    next[j] = (cells[j - 1] == cells[j + 1])? 1: 0;
                }
                cells = next;
            }
        }
        return cells;
    }
}
