class KthLargest {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int size;

    public KthLargest(int k, int[] nums) {
        size = k;

        for (var num : nums) {
            minHeap.offer(num);

            if (minHeap.size() > size) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);

        if (minHeap.size() > size) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
