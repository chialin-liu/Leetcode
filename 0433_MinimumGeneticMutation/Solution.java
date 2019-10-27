class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        for(String str: bank){
            set.add(str);
        }
        if(set.contains(start)){
            set.remove(start);
        }
        char [] charSet = new char[]{'A', 'C', 'G', 'T'};
        queue.offer(start);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.poll();
                for(int idx = 0; idx < cur.length(); idx++){
                    char [] arr = cur.toCharArray();
                    for(int j = 0; j < charSet.length; j++){
                        arr[idx] = charSet[j];
                        String curArr = new String(arr);
                        if(set.contains(curArr)){
                            if(curArr.equals(end)){
                                return level + 1;
                            }
                            else{
                                queue.offer(curArr);
                                set.remove(curArr);
                            }
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
