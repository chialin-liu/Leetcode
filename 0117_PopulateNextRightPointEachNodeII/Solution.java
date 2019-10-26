/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Node pre = null;
        Node start = root;
        Node head = root;
        Node cur = root;
        while(cur != null){
            while(cur != null){
                if(cur.left != null){
                    if(pre != null){
                        pre.next = cur.left;
                    }
                    else{
                        head = cur.left;
                    }
                    pre = cur.left;
                }
                if(cur.right != null){
                    if(pre != null){
                        pre.next = cur.right;
                    }
                    else{
                        head = cur.right;
                    }
                    pre = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            head = null;
            pre = null;
        }
        return start;
    }
}
