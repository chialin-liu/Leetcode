class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for(String str: deadends){
            set.add(str);
        }
        Queue<String> queue = new LinkedList<>();
        String init = "0000";
        Set<String> visited = new HashSet<>();
        if(!set.contains(init)){
            queue.offer(init);
            visited.add(init);
        }
        
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.poll();
                // visited.add(cur);
                if(cur.equals(target)){
                    return time;
                }
                for(int j = 0; j < 4; j++){
                    int pos = cur.charAt(j) - '0';
                    char positive = pos == 9? '0': (char) ((pos + 1) + '0');
                    char negative = pos == 0? '9': (char) ((pos - 1) + '0');
                    String posStr = cur.substring(0, j) + positive + cur.substring(j + 1);
                    String negStr = cur.substring(0, j) + negative + cur.substring(j + 1);
                    // char [] posArr = cur.toCharArray();
                    // posArr[j] = positive;
                    // String posStr = String.valueOf(posArr);
                    // posArr[j] = negative;
                    // String negStr = String.valueOf(posArr);
                    if(!set.contains(posStr) && !visited.contains(posStr)){
                        queue.offer(posStr);
                        visited.add(posStr);
                    }
                    if(!set.contains(negStr) && !visited.contains(negStr)){
                        queue.offer(negStr);
                        visited.add(negStr);
                    }
                }
            }
            time++;
        }
        return -1;
        
    }
}
