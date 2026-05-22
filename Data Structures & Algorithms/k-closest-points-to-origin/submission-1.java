class Solution {
    public int[][] kClosest(int[][] points, int k) {
        var minHeap = new PriorityQueue<int[]>((a, b) -> a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1]);

        for (var point : points) {
            minHeap.offer(point);
        }

        var result = new int[k][2];
        for (var i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
