class FileSystem {
    class TrieNode{
        Map<String, TrieNode> children;
        boolean isFile;
        StringBuilder content;
        String name;
        public TrieNode(String path){
            this.name = path;
            isFile = false;
            content = new StringBuilder();
            children = new HashMap<>();
        }
    }
    TrieNode root;
    public TrieNode buildTrie(String path){
        TrieNode cur = root;
        String []str = path.split("/");
        for(int i = 1; i < str.length; i++){
            TrieNode next = cur.children.get(str[i]);
            if(next == null){
                next = new TrieNode(str[i]);
                cur.children.put(str[i], next);
            }
            cur = next;
        }
        return cur;
    }
    public FileSystem() {
        root = new TrieNode("/");
        
    }
    
    public List<String> ls(String path) {
        TrieNode cur = buildTrie(path);
        List<String> res = new ArrayList<>();
        if(cur.isFile == true){
            res.add(cur.name);
        }
        else{
            for(String child: cur.children.keySet()){
                res.add(child);
            }
        }
        Collections.sort(res);
        return res;
    }
    
    public void mkdir(String path) {
        buildTrie(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        TrieNode cur = buildTrie(filePath);
        cur.isFile = true;
        cur.content.append(content);
    }
    
    public String readContentFromFile(String filePath) {
        TrieNode cur = buildTrie(filePath);
        return cur.content.toString();
    }
    
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
