class Solution {
    public char findTheDifference(String s, String t) {
        Set<Character> set = new HashSet<>();
        int sumS = 0;
        for(Character c: s.toCharArray()){
            // if(!set.contains(c)){
            //     set.add(c);
            // }
            sumS = c - 'a' + sumS;
        }
        char res = '0';
        int sumT = 0;
        for(Character c: t.toCharArray()){
            sumT = c - 'a' + sumT;
        }
        int diff = sumT - sumS;
        res =  (char) (diff + 'a') ;
        return res;
    }
}
