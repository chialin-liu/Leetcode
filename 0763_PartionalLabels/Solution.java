class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        int []map = new int[26];
        int index = 0;
        for(char cur: S.toCharArray()){
            map[cur - 'a'] = index;
            index++;
        }
        int last = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++){
            last = Math.max(last, map[S.charAt(i) - 'a']);
            if(i == last){
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }
    
}
