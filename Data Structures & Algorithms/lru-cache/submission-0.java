class LRUCache {
    Map<Integer, Node> cache;
    int capacity;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        remove(node);
        addToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node curr = cache.get(key);
            curr.val = value;
            remove(curr);
            addToHead(curr);
        } else {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            if(cache.size() > capacity) {
                Node lru = tail.prev;
                remove(lru);
                cache.remove(lru.key);
            }
        }
        
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
public class Node {
    int key, val;
    Node prev;
    Node next;

    public Node(int key, int val)
    {   
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

