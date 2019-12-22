class Solution {
    public String removeVowels(String S) {
        StringBuilder sb = new StringBuilder();
        for(char cur: S.toCharArray()){
            if(cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') continue;
            else{
                sb.append(cur);
            }
        }
        return sb.toString();
    }
}
