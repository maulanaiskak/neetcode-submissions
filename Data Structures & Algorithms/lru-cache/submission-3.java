class LRUCache {
    Node head;
    Node tail;
    Map<Integer, Node> data;
    int capacity;

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;

        data = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!data.containsKey(key)) {
            return -1;
        }

        var node = data.get(key);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (data.containsKey(key)) {
            var node = data.get(key);
            node.value = value;
            moveToHead(node);
            return;
        }

        var node = new Node();
        node.key = key;
        node.value = value;

        data.put(key, node);
        addToHead(node);

        if (data.size() > capacity) {
            var lru = tail.prev;
            removeNode(lru);
            data.remove(lru.key);
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
