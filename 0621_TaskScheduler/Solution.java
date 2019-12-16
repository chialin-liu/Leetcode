class Solution {
    public int leastInterval(char[] tasks, int n) {
        int max = 0;
        int maxCount = 0;
        char []arr = new char[26];
        for(char c: tasks){
            arr[c - 'A']++;
            if(max < arr[c - 'A']){
                max = arr[c - 'A'];
                maxCount = 1;
            }
            else if(max == arr[c - 'A']){
                maxCount++;
            }
        }
        int parCount = max - 1;
        int empty = parCount * (n - (maxCount - 1));
        int available = tasks.length - max * maxCount;
        int idel = Math.max(0, empty - available);
        return tasks.length + idel;
    }
}
