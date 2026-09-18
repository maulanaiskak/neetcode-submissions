class LRUCache {
    private Map<Integer, Node> data;
    private int capacity;
    private Node head;
    private Node tail;

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        data = new HashMap<>();
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!data.containsKey(key)) {
            return -1;
        }

        var node = data.get(key);
        remove(node);
        addToHead(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if (data.containsKey(key)) {
            var node = data.get(key);
            node.value = value;

            remove(node);
            addToHead(node);
            return;
        }

        var node = new Node();
        node.key = key;
        node.value = value;

        data.put(key, node);
        addToHead(node);

        if (data.size() > capacity) {
            var deleted = tail.prev;
            data.remove(deleted.key);
            remove(deleted);
        }
    }

    private void remove(Node node) {
        var next = node.next;
        var prev = node.prev;

        prev.next = next;
        next.prev = prev;
    }

    private void addToHead(Node node) {
        var next = head.next;

        head.next = node;
        next.prev = node;
        
        node.prev = head;
        node.next = next;
    }
}
