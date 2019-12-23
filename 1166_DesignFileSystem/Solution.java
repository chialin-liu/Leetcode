class FileSystem {
    Map<String, Integer> map;
    public FileSystem() {
        map = new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        String []arr = path.split("/");
        String cur = "";
        if(arr.length > 2){
            for(int i = 1; i < arr.length - 1; i++){
                cur = (i == 1)? arr[i]: cur + "+" + arr[i];
            }
            if(!map.containsKey(cur)){
                return false;
            }
        }
        cur =(arr.length == 2)? arr[1]: cur + "+" +  arr[arr.length - 1];
        if(map.containsKey(cur)){
            return false;
        }
        map.put(cur, value);
        return true;
    }
    
    public int get(String path) {
        String []arr = path.split("/");
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < arr.length ; i++){
            sb.append(arr[i]);
            if(i == arr.length - 1) continue;
            else{
                sb.append("+");
            }
        }
        String cur = sb.toString();
        return map.getOrDefault(cur, -1);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
