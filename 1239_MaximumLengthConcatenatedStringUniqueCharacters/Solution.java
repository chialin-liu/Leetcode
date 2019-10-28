class Solution {
    public int maxLength(List<String> arr) {
        Set<Character> set = new HashSet<>();
        boolean duplicate = false;
        int length = 0;
        for(int i = 0; i < arr.size(); i++){
            set = new HashSet<>();
            duplicate = false;
            for(char c: arr.get(i).toCharArray()){
                if(set.contains(c)){
                    duplicate = true;
                    break;
                }
                else{
                    set.add(c);
                }
            }
            if(duplicate == true) continue;
            length = Math.max(length, set.size());
            for(int j = 0; j < arr.size(); j++){
                if(i == j) continue;
                Set<Character> compare = new HashSet<>();
                duplicate = false;
                for(char c: arr.get(j).toCharArray()){
                    if(compare.contains(c) || set.contains(c)){
                        duplicate = true;
                        break;
                    }
                    else{
                        compare.add(c);
                    }
                }
                if(!duplicate){
                    set.addAll(compare);
                }
                
                length = Math.max(length, set.size());
            }
        }
        return length;
    }
}
