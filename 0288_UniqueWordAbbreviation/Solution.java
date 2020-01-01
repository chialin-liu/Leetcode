class ValidWordAbbr {
    Map<String, List<String>> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for(String word: dictionary){
            StringBuilder sb = new StringBuilder();
            int len = word.length();
            if(len <= 2){
                if(map.containsKey(word)){
                    List<String> list = map.get(word);
                    list.add(word);
                }
                else{
                    List<String> list =  new ArrayList<>();
                    list.add(word);
                    map.put(word, list);
                }
            }
            else{
                sb.append(word.charAt(0));
                sb.append(String.valueOf(len - 2));
                sb.append(word.charAt(len - 1));
                if(map.containsKey(sb.toString())){
                    List<String> list = map.get(sb.toString());
                    list.add(word);
                }
                else{
                    List<String> list = new ArrayList<>();
                    list.add(word);
                    map.put(sb.toString(), list);
                }
            }
        }
    }
    
    public boolean isUnique(String word) {
        int len = word.length();
        StringBuilder sb = new StringBuilder();
        if(len <= 2){
            return true;
        }
        else{
            sb.append(word.charAt(0));
            sb.append(String.valueOf(len - 2));
            sb.append(word.charAt(len - 1));
            if(map.containsKey(sb.toString())){
                List<String> list = map.get(sb.toString());
                return list.size() == 1 && list.contains(word);
            }
            else{
                return true;
            }
        }
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
