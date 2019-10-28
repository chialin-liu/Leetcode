class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> unvisited = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Map<String, List<String>> map = new HashMap<>();
        boolean found = false;
        queue.offer(beginWord);
        visited.add(beginWord);
        List<List<String>> res = new ArrayList<>();
        if(wordList.size() == 0) return res;
        if(unvisited.contains(beginWord)){
            unvisited.remove(beginWord);
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int ii = 0; ii < size; ii++){
                String cur = queue.poll();
                for(int i = 0; i < cur.length(); i++){
                    char [] arr = cur.toCharArray();  
                    for(char c = 'a'; c <= 'z'; c++){
                        arr[i] = c;
                        String newStr = new String(arr);
                        if(unvisited.contains(newStr)){
                            if(!visited.contains(newStr)){
                                queue.offer(newStr);
                                visited.add(newStr);
                            }
                            if(map.containsKey(newStr)){
                                List<String> list = map.get(newStr);
                                list.add(cur);
                                map.put(newStr, list);
                            }
                            else{
                                List<String> list = new ArrayList<>();
                                list.add(cur);
                                map.put(newStr, list);
                            }  
                            if(newStr.equals(endWord)){
                                found = true;
                            }
                        }
                        
                    }
                }
            }
            if(found) break;
            unvisited.removeAll(visited);
            visited.clear();
        }
        dfs(res, new ArrayList<String>(), map, endWord, beginWord);
        return res;
    }
    public void dfs(List<List<String>> res, List<String> list, Map<String, List<String>> map, String word, String start){
        if(word.equals(start)){
            list.add(0, word);
            res.add(new ArrayList<>(list));
            list.remove(0);
        }
        list.add(0, word);
        if(map.get(word) != null){
            for(String cur: map.get(word)){
                dfs(res, list, map, cur, start);
            }
        }
        list.remove(0);
    }
    
}
