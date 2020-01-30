class Solution {
    public String reorganizeString(String S) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char cur: S.toCharArray()){
            freq.put(cur, freq.getOrDefault(cur, 0) + 1);
            int count = freq.get(cur);
            if(count > (S.length() + 1) / 2) return "";
        }
        PriorityQueue<int []> queue = new PriorityQueue<>(new Comparator<int []>(){
            public int compare(int []a, int []b){
                return b[1] - a[1];
            }
        });
        for(char cur: freq.keySet()){
            queue.offer(new int[]{cur, freq.get(cur)});
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int []first = queue.poll();
            if(sb.length() == 0 || (char)first[0] != sb.charAt(sb.length() - 1)){
                sb.append((char) first[0]);
                first[1]--;
                if(first[1] > 0){
                    queue.offer(first);
                }
            }
            else{
                int []second = queue.poll();
                sb.append((char)second[0]);
                second[1]--;
                if(second[1] > 0){
                    queue.offer(second);
                }
                queue.offer(first);
            }
        }
        return sb.toString();
    }
}
