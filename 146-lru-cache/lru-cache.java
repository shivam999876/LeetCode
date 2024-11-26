class LRUCache {
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> cache;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        
       
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

   

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void add(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            add(node);
            return node.value;
        }
        return -1;
        
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
             remove(cache.get(key));
        }
        Node newNode = new Node(key, value);
        add(newNode);
        cache.put(key, newNode);

        if (cache.size() > capacity) {
            Node lru = tail.prev;
            remove(lru);
            cache.remove(lru.key);
        }
        
    }
}

public class Main {
    public static void main(String[] args) {
       LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);   
        lruCache.put(2, 2);    
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);    
        System.out.println(lruCache.get(2)); 
        lruCache.put(4, 4);   
        System.out.println(lruCache.get(1)); 
        System.out.println(lruCache.get(3)); 
        System.out.println(lruCache.get(4)); 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */