class Solution {
    public int[][] kClosest(int[][] points, int k) {
        var minHeap = new PriorityQueue<int[]>(
            Comparator.comparingInt(
                p -> p[0] * p[0] + p[1] * p[1]
            )
        );

        for (var point : points) {
            minHeap.offer(point);
        }

        var result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}