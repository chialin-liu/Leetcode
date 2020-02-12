class Solution {
    public List<String> commonChars(String[] A) {
        int []target = new int[26];
        int index = 0;
        for(char c: A[0].toCharArray()){
            target[c - 'a']++;
        }
        int []compare = new int[26];
        for(int i = 1; i < A.length; i++){
            compare = new int[26];
            for(char c: A[i].toCharArray()){
                compare[c - 'a']++;
            } 
            for(int j = 0; j < 26; j++){
                if(target[j] > compare[j]){
                    target[j] = compare[j];
                }
            }
        }
        List<String> res = new ArrayList<>();
        for(int j = 0; j < 26; j++){
            while(target[j] != 0){
                res.add(String.valueOf((char)(j + 'a')));
                target[j]--;
            }
        }
        return res;
    }
}
