class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for(String path: paths){
            String []cur = path.split(" ");
            for(int i = 1; i < cur.length; i++){
                int start = cur[i].indexOf("(");
                String content = cur[i].substring(start);
                if(map.containsKey(content)){
                    List<String> list = map.get(content);
                    String newStr = cur[0] + "/" + cur[i].substring(0, start);
                    list.add(newStr);
                }
                else{
                    List<String> list = new ArrayList<>();
                    String newStr = cur[0] + "/" + cur[i].substring(0, start);
                    list.add(newStr);
                    map.put(content, list);
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> list: map.values()){
            if(list.size() >= 2){
                res.add(new ArrayList<>(list));
            }
        }
        return res;
    }
}
