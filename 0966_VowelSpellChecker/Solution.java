class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Map<String, String> cap = new HashMap<>();
        Map<String, String> vowel = new HashMap<>();
        List<String> wordlistArr = new ArrayList<>();
        for(String word: wordlist){
            wordlistArr.add(word);
            String lower = word.toLowerCase();
            if(!cap.containsKey(lower)){
                cap.put(lower, word);
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < word.length(); i++){
                if(lower.charAt(i) == 'a' || lower.charAt(i) == 'e' || lower.charAt(i) == 'i' || lower.charAt(i) == 'o' || lower.charAt(i) == 'u'){
                    sb.append("#");
                }
                else{
                    sb.append(lower.charAt(i));
                }
            }
            if(!vowel.containsKey(sb.toString())){
                vowel.put(sb.toString(), word);
            }
        }
        
        
        for(int i = 0; i < queries.length; i++){
            String lower = queries[i].toLowerCase();
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < queries[i].length(); j++){
                if(lower.charAt(j) == 'a' || lower.charAt(j) == 'e' || lower.charAt(j) == 'i' || lower.charAt(j) == 'o' || lower.charAt(j) == 'u'){
                    sb.append("#");
                }
                else{
                    sb.append(lower.charAt(j));
                }
            }
            String vow = sb.toString();
            if(wordlistArr.contains(queries[i])) continue;
            else if(cap.containsKey(lower)){
                queries[i] = cap.get(lower);
            }
            else if(vowel.containsKey(vow)){
                queries[i] = vowel.get(vow);
            }
            else{
                queries[i] = "";
            }
        }
        return queries;
    }
}
