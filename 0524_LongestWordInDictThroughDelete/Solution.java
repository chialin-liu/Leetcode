class Solution {
    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        for(String str: d){
            int i = 0;
            for(char cur: s.toCharArray()){
                if(i < str.length() && str.charAt(i) == cur){
                    i++;
                }
            }
            if(i == str.length()){
                if(str.length() >= longest.length()){
                    if(str.length() == longest.length() && str.compareTo(longest) < 0){
                        longest = str;
                    }
                    else if(str.length() > longest.length()){
                        longest = str;
                    }
                }
            }
        }
        return longest;
    }
}
