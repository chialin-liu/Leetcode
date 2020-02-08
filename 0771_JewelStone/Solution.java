class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> j = new HashSet<>();
        for(char cur: J.toCharArray()){
            j.add(cur);
        }
        int count = 0;
        for(char cur: S.toCharArray()){
           if(j.contains(cur)){
               count++;
           }
        
        }
        return count;
    }
}
