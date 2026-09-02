class MyHashSet {
    private final LinkedList<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[1000];

        for (var i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

    }

    public void add(int key) {
        var bucket = buckets[key % buckets.length];

        if (!bucket.contains(key)) {
            bucket.add(key);
        }

    }

    public void remove(int key) {
        buckets[key % buckets.length].remove((Integer) key);
    }

    public boolean contains(int key) {
        return buckets[key % buckets.length].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */