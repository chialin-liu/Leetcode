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
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node cur = queue.poll();
                list.add(cur.val);
                for(Node neighbor: cur.children){
                    queue.offer(neighbor);
                }
            }
            res.add(list);
        }
        return res;
    }
}
