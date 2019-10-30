/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root == null) return 0;
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node cur = queue.poll();
                for(Node neighbor: cur.children){
                    if(neighbor != null){
                        queue.offer(neighbor);
                    }
                }
            }
            level++;
        }
        return level;
    }
}
