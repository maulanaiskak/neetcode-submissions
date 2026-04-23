class Solution {
    public int[][] kClosest(int[][] points, int k) {
        var maxHeap = new PriorityQueue<int[]>(
                        (a, b) -> {
                            var distA = 1L * a[0] * a[0] + 1L * a[1] * a[1];
                            var distB = 1L * b[0] * b[0] + 1L * b[1] * b[1];
                            return Long.compare(distB, distA);
                        }
                    );

        for (var point : points) {
            maxHeap.add(point);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        var size = maxHeap.size();
        var result = new int[size][2];

        for (int i = 0; i < size; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }
}
