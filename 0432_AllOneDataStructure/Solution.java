class AllOne {
    class Node{
        Node pre;
        Node next;
        int value;
        Set<String> keys;
        public Node(int value){
            this.value = value;
            pre = null;
            next = null;
            keys = new LinkedHashSet<>();
        }
        public Node(){
            this.value = -1;
            pre = null;
            next = null;
            keys = new LinkedHashSet<>();
        }
    }
    Map<String, Node> map;
    Node head;
    Node tail;
    /** Initialize your data structure here. */
    public AllOne() {
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }
    public void addNext(Node curNode, Node newNode){
        Node temp = curNode.next;
        newNode.pre = curNode;
        newNode.next = temp;
        curNode.next = newNode;
        temp.pre = newNode;
    }
    public void addPre(Node curNode, Node newNode){
        Node temp = curNode.pre;
        newNode.pre = temp;
        newNode.next = curNode;
        curNode.pre = newNode;
        temp.next = newNode;
    }
    public void removeNode(Node curNode){
        Node preNode = curNode.pre;
        Node nextNode = curNode.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
    }
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(map.containsKey(key)){
            Node curNode = map.get(key);
            int curValue = curNode.value;
            Node newNode;
            int incrementValue = curValue + 1;
            if(curNode.next.value == incrementValue){
                newNode = curNode.next;
                newNode.keys.add(key);
            }
            else{
                newNode = new Node(incrementValue);
                addNext(curNode, newNode);
                newNode.keys.add(key);
            }
            curNode.keys.remove(key);
            if(curNode.keys.size() == 0){
                removeNode(curNode);
            }
            
            map.put(key, newNode);
        }
        else{
            if(head.next.value == 1){
                Node curNode = head.next;
                curNode.keys.add(key);
                map.put(key, curNode);
            }
            else{
                Node newNode = new Node(1);
                addNext(head, newNode);
                newNode.keys.add(key);
                map.put(key, newNode);
            }
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(map.containsKey(key)){
            Node curNode = map.get(key);
            int curValue = curNode.value;
            int decrementValue = curValue - 1;
            if(decrementValue == 0){
                curNode.keys.remove(key);
                if(curNode.keys.size() == 0){
                    removeNode(curNode);
                }
                map.remove(key);
            }
            else{
                Node preNode;
                if(curNode.pre.value == decrementValue){
                    preNode = curNode.pre;
                    preNode.keys.add(key);

                }
                else{
                    preNode = new Node(decrementValue);
                    addPre(curNode, preNode);
                    preNode.keys.add(key);
                }
                curNode.keys.remove(key);
                if(curNode.keys.size() == 0){
                    removeNode(curNode);
                }
                map.put(key, preNode);
            }
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(tail.pre == head){
            return "";
        }
        else{
            Node curNode = tail.pre;
            return curNode.keys.iterator().next();
        }
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(head.next == tail){
            return "";
        }
        else{
            Node curNode = head.next;
            return curNode.keys.iterator().next();
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
