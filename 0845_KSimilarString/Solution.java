class Solution {
    public int kSimilarity(String A, String B) {
        if(A.equals(B)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(A);
        Set<String> set = new HashSet<>();
        set.add(A);
        int res = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            res++;
            for(int s = 0; s < size; s++){
                String cur = queue.poll();
                int start = 0;
                while(start < A.length() && cur.charAt(start) == B.charAt(start)){
                    start++;
                }
                for(int next = start + 1; next < A.length(); next++){
                    if(cur.charAt(next) == B.charAt(next) || cur.charAt(start) != B.charAt(next)) continue;
                    String nextString = swap(cur, start, next);
                    if(nextString.equals(B)){
                        return res;
                    }
                    if(!set.contains(nextString)){
                        queue.offer(nextString);
                        set.add(nextString);
                    }
                }
            }
            
            
        }
        return res;
    }
    public String swap(String cur, int i, int j){
        String newString = cur;
        char tmp = newString.charAt(i);
        char []arr = newString.toCharArray();
        arr[i] = arr[j];
        arr[j] = tmp;
        return String.valueOf(arr);
    }
}
