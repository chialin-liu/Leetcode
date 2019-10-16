class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String>  map = new HashMap<>();
        char [] arr = pattern.toCharArray();
        String [] sp = str.split(" ");
        if(arr.length != sp.length) return false;
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                String val = map.get(arr[i]);
                if(!val.equals(sp[i])){
                    return false;
                }
            }
            else{
                if(map.containsValue(sp[i])){
                    return false;
                }
                else{
                    map.put(arr[i], sp[i]);
                }
                
            }
        }
        return true;
    }
}
