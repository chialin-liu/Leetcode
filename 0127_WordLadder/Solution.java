class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null){
            return 0;
        }
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        if(set.contains(beginWord)){
            set.remove(beginWord);
        }
        queue.offer(beginWord);
        int size = 0;
        int length = 1;
        while(!queue.isEmpty()){
            size = queue.size();
            length++;
            for(int ss = 0; ss < size; ss++){
                String str = queue.poll();
                for(int i = 0; i < str.length(); i++){
                    char [] charArray = str.toCharArray();
                    for(char j = 'a'; j < 'z'; j++){
                        charArray[i] = j;
                        String newStr = new String(charArray);
                        if(set.contains(newStr)){
                            if(newStr.equals(endWord)){
                                return length ;
                            }
                            set.remove(newStr);
                            queue.offer(newStr);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
