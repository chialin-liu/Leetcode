class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, new Comparator<>(){
           public int compare(String s1, String s2){
               if(s1.length() == s2.length()){
                   return s1.compareTo(s2);
               }
               else{
                   return s2.length() - s1.length();
               }
           } 
        });
        Set<String> set = new HashSet<>();
        for(String str: words){
            set.add(str);
        }
        boolean isOk = true;
        for(int i = 0; i < words.length; i++){
            String cur = words[i];
            isOk = true;
            for(int j = 0; j < cur.length(); j++){
                String temp = cur.substring(0, j + 1);
                if(set.contains(temp)) continue;
                else {
                    isOk = false;
                    break;
                }
            }
            if(isOk){
                return cur;
            }
        }
        return "";
    }
}
