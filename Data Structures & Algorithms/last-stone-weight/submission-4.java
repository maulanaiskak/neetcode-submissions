class Solution {
    public int lastStoneWeight(int[] stones) {
        var maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() >= 2) {
            int delta = maxHeap.poll() - maxHeap.poll();
            
            if (delta > 0) {
                maxHeap.offer(delta);
            }
        }

        return maxHeap.size() > 0 ? maxHeap.poll() : 0;
    }
}
