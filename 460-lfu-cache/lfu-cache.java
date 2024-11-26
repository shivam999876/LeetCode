import java.util.*;

class LFUCache {

    // \U0001f9e9 Node class represents each cache entry
    class CacheNode {
        int key, value, frequency;
        CacheNode prev, next;

        CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1; // \U0001f522 Frequency starts at 1
        }
    }

    // \U0001f517 Doubly Linked List to store nodes with the same frequency
    class FrequencyList {
        CacheNode head, tail; // \U0001f6d1 Dummy head and tail for easy insertion/removal
        int size; // \U0001f4cf Number of nodes in the list

        FrequencyList() {
            head = new CacheNode(0, 0); // \U0001faa7 Dummy head node
            tail = new CacheNode(0, 0); // \U0001faa7 Dummy tail node
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // \U0001f195 Add a new node to the front (most recently used in this frequency)
        void addNodeToFront(CacheNode node) {
            CacheNode firstNode = head.next;
            head.next = node;
            node.prev = head;
            node.next = firstNode;
            firstNode.prev = node;
            size++;
        }

        // \U0001f5d1️ Remove a specific node
        void removeNode(CacheNode node) {
            CacheNode prevNode = node.prev;
            CacheNode nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }

        // \U0001f6aa Remove and return the least recently used node (last in the list)
        CacheNode removeLastNode() {
            if (size > 0) {
                CacheNode lastNode = tail.prev;
                removeNode(lastNode);
                return lastNode;
            }
            return null;
        }
    }

    // \U0001f31f Cache properties
    private int cacheCapacity, minFrequency;
    private Map<Integer, CacheNode> keyToCacheNode; // \U0001f5c2️ Maps key -> node
    private Map<Integer, FrequencyList> frequencyToList; // \U0001f517 Maps frequency -> DLL of nodes

    // \U0001f527 Constructor
    public LFUCache(int capacity) {
        this.cacheCapacity = capacity;
        this.minFrequency = 0; // \U0001f522 Minimum frequency starts at 0
        this.keyToCacheNode = new HashMap<>();
        this.frequencyToList = new HashMap<>();
    }

    // \U0001f3af Get the value of a key
    public int get(int key) {
        if (!keyToCacheNode.containsKey(key)) {
            return -1; // \U0001f6ab Key not found
        }

        CacheNode node = keyToCacheNode.get(key);
        updateNodeFrequency(node); // \U0001f504 Update frequency on access
        return node.value;
    }

    // ✍️ Insert or update a key-value pair
    public void put(int key, int value) {
        if (cacheCapacity == 0) return; // \U0001f6ab No capacity, do nothing

        if (keyToCacheNode.containsKey(key)) {
            CacheNode node = keyToCacheNode.get(key);
            node.value = value; // \U0001f58a️ Update value
            updateNodeFrequency(node); // \U0001f504 Update frequency
            return;
        }

        if (keyToCacheNode.size() >= cacheCapacity) {
            // \U0001f5d1️ Evict the least frequently used node
            FrequencyList minFreqList = frequencyToList.get(minFrequency);
            CacheNode nodeToRemove = minFreqList.removeLastNode();
            keyToCacheNode.remove(nodeToRemove.key);
        }

        // \U0001f195 Add new node
        CacheNode newNode = new CacheNode(key, value);
        keyToCacheNode.put(key, newNode);
        minFrequency = 1; // Reset `minFrequency` to 1
        frequencyToList.computeIfAbsent(1, k -> new FrequencyList()).addNodeToFront(newNode);
    }

    // \U0001f504 Update a node's frequency
    private void updateNodeFrequency(CacheNode node) {
        int oldFreq = node.frequency;
        FrequencyList oldFreqList = frequencyToList.get(oldFreq);
        oldFreqList.removeNode(node); // \U0001f5d1️ Remove from current frequency list

        // \U0001f31f If list is empty and matches `minFrequency`, increment `minFrequency`
        if (oldFreq == minFrequency && oldFreqList.size == 0) {
            minFrequency++;
        }

        // \U0001f522 Increase frequency and move to the new frequency list
        node.frequency++;
        frequencyToList.computeIfAbsent(node.frequency, k -> new FrequencyList()).addNodeToFront(node);
    }
}