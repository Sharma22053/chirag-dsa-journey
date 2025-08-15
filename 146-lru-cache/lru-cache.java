class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int cap;
    HashMap<Integer,Node> hmap = new HashMap<>();

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node newNode){
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;

        head.next = newNode;
        temp.prev = newNode;
    }

    private void deleteNode(Node delNode){
        Node prevv = delNode.prev;
        Node nextt = delNode.next;

        prevv.next = nextt;
        nextt.prev = prevv;
    }
    
    public int get(int key) {
        if(hmap.containsKey(key)){
            Node resNode = hmap.get(key);
            int ans = resNode.val;

            hmap.remove(key);
            deleteNode(resNode);
            addNode(resNode);
            hmap.put(key,head.next);
            return ans;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hmap.containsKey(key)){
            Node current = hmap.get(key);
            hmap.remove(key);
            deleteNode(current);
        }

        if(hmap.size() == cap){
            hmap.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        addNode(new Node(key,value));
        hmap.put(key,head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */