class MyHashMap {
    private class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private final Node[] buckets;

    public MyHashMap() {
        buckets = new Node[1000];
    }

    private int getIndex(int key) {
        return key % buckets.length;
    }
    
    public void put(int key, int value) {
        var node = buckets[getIndex(key)];

        if (node == null) {
            buckets[getIndex(key)] = new Node(key, value);
            return;
        }

        while (true) {
            if (node.key == key) {
                node.value = value;
                return;
            }

            if (node.next == null) {
                break;
            }

            node = node.next;
        }

        node.next = new Node(key, value);
    }
    
    public int get(int key) {
        var node = buckets[getIndex(key)];

        while (node != null) {
            if (node.key == key) {
                return node.value;
            }

            node = node.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        var index = getIndex(key);
        var node = buckets[index];

        if (node == null) {
            return;
        }

        if (node.key == key) {
            buckets[index] = node.next;
            return;
        }

        var prev = node;
        node = node.next;

        while (node != null) {
            if (node.key == key) {
                prev.next = node.next;
                return;
            }

            prev = node;
            node = node.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */