class MedianFinder {
    private PriorityQueue<Integer> leftHeap;
    private PriorityQueue<Integer> rightHeap;

    public MedianFinder() {
        leftHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
        rightHeap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if (leftHeap.size() == 0 || num <= leftHeap.peek()) {
            leftHeap.add(num);
        } else {
            rightHeap.add(num);
        }

        if (rightHeap.size() > leftHeap.size()) {
            leftHeap.add(rightHeap.poll());
        }

        if (leftHeap.size() > rightHeap.size() + 1) {
            rightHeap.add(leftHeap.poll());
        }
    }
    
    public double findMedian() {
        if ((leftHeap.size() + rightHeap.size()) % 2 == 0) {
            return (leftHeap.peek() + rightHeap.peek()) / 2.0;
        }

        return leftHeap.peek();
    }
}
