class LRUCache {
    class Node{
        Node pre;
        Node next;
        int key;
        int value;
        public Node(int key, int value){
            // this.pre = null;
            // this.next = null;
            this.key = key;
            this.value = value;
        }
    }
    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        Node cur = map.get(key);
        if(cur == null) return -1;
        else{
            if(cur != tail){
                if(cur == head){
                    head = head.next;
                }
                else{
                    cur.pre.next = cur.next;
                    cur.next.pre = cur.pre;
                }
                tail.next = cur;
                cur.pre = tail;
                cur.next = null;
                tail = cur;
            }   
            return cur.value;
        }
    }
    
    public void put(int key, int value) {
        Node cur = map.get(key);
        if(cur != null){
            cur.value = value;
            if(cur != tail){
                if(cur == head){
                    head = head.next;
                }
                else{
                    cur.pre.next = cur.next;
                    cur.next.pre = cur.pre;
                }
                tail.next = cur;
                cur.pre = tail;
                cur.next = null;
                tail = cur;
            }
            map.put(key, cur);
        }
        else{
            Node newNode = new Node(key, value);
            if(capacity == 0){
                Node tmp = head;
                head = head.next;
                map.remove(tmp.key);
                capacity++;
            }
            
                if(head == null && tail == null){
                    head = newNode;
                }
                else{
                    tail.next = newNode;
                    newNode.pre = tail;
                    newNode.next = null;
                }
            tail = newNode;
            capacity--;
            map.put(key, newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
