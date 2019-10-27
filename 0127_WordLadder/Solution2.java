class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(set.contains(beginWord)){
            set.remove(beginWord);
        }
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            String cur = queue.poll();
            int curLevel = map.get(cur);
            for(int i = 0; i < cur.length(); i++){
                for(char j = 'a'; j <= 'z'; j++){
                    char [] arr = cur.toCharArray();
                    arr[i] = j;
                    String newStr = new String(arr);
                    if(set.contains(newStr)){
                        if(newStr.equals(endWord)){
                            return curLevel + 1;
                        }
                        else{
                            queue.offer(newStr);
                            map.put(newStr, curLevel + 1);
                            set.remove(newStr);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
