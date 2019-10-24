class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return "/";
        Stack<String> stack = new Stack<>();
        String [] str = path.split("/+");
        for(String cur: str){
            if(cur.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else if(!cur.equals(".") && !cur.equals("")){
                stack.push(cur);
            }
        }
        String res = "";
        while(!stack.isEmpty()){
            res = "/" + stack.pop() + res;
        }
        if(res.length() == 0){
            return "/";
        }
        else{
            return res;
        }
    }
}
