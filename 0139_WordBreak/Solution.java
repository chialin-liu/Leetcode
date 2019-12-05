class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict == null) return false;
        Queue<Integer> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for(String cur: wordDict){
            set.add(cur);
        }
        int maxLength = 0;
        for(String curStr : wordDict){
            maxLength = Math.max(maxLength, curStr.length());
        
        }
        boolean []visited = new boolean[s.length() + 1];
        queue.offer(0);
        visited[0] = true;
        while(!queue.isEmpty()){
            int start = queue.poll();
            for(int i = start + 1; i - start <= maxLength && i <= s.length(); i++){
                if(visited[i] == true) continue;
                if(set.contains(s.substring(start, i))){
                    if(i == s.length()) {
                        return true;
                    }
                    queue.offer(i);
                    visited[i] = true;
                }
            }
            
        }
        return false;
    }
}
