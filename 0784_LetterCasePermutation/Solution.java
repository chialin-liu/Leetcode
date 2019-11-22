class Solution {
    public List<String> letterCasePermutation(String S) {
        Queue<String> queue = new LinkedList<>();
        List<String> res = new ArrayList<>();
        if(S == null || S.length() == 0) return res;
        queue.offer(S);
        for(int i = 0; i < S.length(); i++){
            if(Character.isDigit(S.charAt(i))) continue;
            int size = queue.size();
            for(int j = 0; j < size; j++){
                String cur = queue.poll();
                char [] curArr = cur.toCharArray();
                
                curArr[i] = Character.toUpperCase(curArr[i]);
                queue.offer(String.valueOf(curArr));
                
                curArr[i] = Character.toLowerCase(curArr[i]);
                queue.offer(String.valueOf(curArr));
            }
        }
        return new ArrayList<>(queue);
    }
}
