class Solution {
    public int lastStoneWeight(int[] stones) {
        var maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for (var stone : stones) {
            if (stone > 0) {
                maxHeap.offer(stone);
            }
        }

        while (maxHeap.size() > 1) {
            var stone1 = maxHeap.poll();
            var stone2 = maxHeap.poll();
            var delta = stone1 - stone2;

            if (delta > 0) {
                maxHeap.offer(delta);
            }
        }

        return maxHeap.peek() == null ? 0 : maxHeap.peek();
    }
}
