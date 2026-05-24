class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);

        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.offer(maxHeap.poll());
        }

        if (minHeap.size() + 1 < maxHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if ((minHeap.size() + maxHeap.size()) % 2 == 0) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2.0;
        } 

        return maxHeap.peek();
    }
}
