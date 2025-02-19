class LRUCache {
    class Node{
        int key,val;
        Node next, prev;

        Node(int key,int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    void delete(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        // System.out.println("delete "+node.key+" "+node.val);
    }

    void insert(Node node){
        Node next = head.next;
        head.next = node;
        node.prev = head;
        next.prev = node;
        node.next = next;
        // System.out.println("insert "+node.key+" "+node.val);

    }
    int cap;
    Node head,tail;
    Map<Integer,Node> map;


    public LRUCache(int capacity) {
        cap = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<Integer,Node>();
    }
    
    public int get(int key) {
       if(!map.containsKey(key)) return -1;
       Node node = map.get(key);
       delete(node);
       insert(node);
       return node.val;
    }
    
    public void put(int key, int value) {
        int g = get(key);
        if(g != -1){
            Node node = map.get(key);
            node.val = value;
            map.put(key,node);
        }else{
            Node node = new Node(key,value);
            insert(node);
            map.put(key,node);
        }
        // System.out.println("map "+map);
        if(map.size() > cap){
            map.remove(tail.prev.key);
            delete(tail.prev);
            
        }
        // System.out.println("map "+map);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */