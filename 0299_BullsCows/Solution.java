class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < secret.length(); i++){
            map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
        }
        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bull++;
                int val = map.get(secret.charAt(i));
                val--;
                map.put(secret.charAt(i), val);
            }
        }
        for(int i = 0; i < secret.length(); i++){
              if(secret.charAt(i) == guess.charAt(i)) continue;
    
                if(map.getOrDefault(guess.charAt(i), 0) != 0){
                    cow++;
                    int val = map.get(guess.charAt(i));
                    val--;
                    map.put(guess.charAt(i), val); 
                }
        } 
        return String.valueOf(bull) + "A" + String.valueOf(cow) + "B";
    }
}
