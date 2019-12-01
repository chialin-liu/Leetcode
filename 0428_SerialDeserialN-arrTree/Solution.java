/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        List<String> list = new ArrayList<>();
        if(root == null) return null;
        serialHelper(root, list);
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for(int i = 0; i < list.size() - 1; i++){
            sb.append(list.get(i));
            sb.append(",");
        }
        sb.append(list.get(size - 1));
        return sb.toString();
    }
    public void serialHelper(Node root, List<String> list){
        if(root == null) return;
        list.add(String.valueOf(root.val));
        list.add(String.valueOf(root.children.size()));
        for(Node child: root.children){
            serialHelper(child, list);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        Queue<Integer> queue = new LinkedList<>();
        String []str = data.split(",");
        for(int i = 0; i < str.length; i++){
            queue.offer(Integer.valueOf(str[i]));
        }
        Node root = deserialHelper(queue);
        return root;
    }
    public Node deserialHelper(Queue<Integer> queue){
        Node root = new Node();
        root.val = queue.poll();
        int size = queue.poll();
        root.children = new ArrayList<>();
        for(int i = 0; i < size; i++){
            root.children.add(deserialHelper(queue));
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
