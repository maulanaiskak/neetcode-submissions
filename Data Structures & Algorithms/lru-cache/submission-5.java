class LRUCache {
    private Map<Integer, Node> data;
    private Node head;
    private Node tail;
    private int capacity;

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    public LRUCache(int capacity) {
        data = new HashMap<>();
        this.capacity = capacity;
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
        putToFront(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if (data.containsKey(key)) {
            var node = data.get(key);
            node.value = value;

            remove(node);
            putToFront(node);
            
            return;
        }

        var node = new Node();
        node.key = key;
        node.value = value;

        putToFront(node);
        data.put(key, node);

        if (data.size() > capacity) {
            var deleted = tail.prev;
            data.remove(deleted.key);
            remove(deleted);
        }
    }

    private void remove(Node node) {
        var prev = node.prev;
        var next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void putToFront(Node node) {
        var next = head.next;

        node.prev = head;
        node.next = next;

        head.next = node;
        next.prev = node;
    }
}
