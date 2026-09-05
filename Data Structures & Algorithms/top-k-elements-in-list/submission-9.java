class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var freq = new HashMap<Integer, Integer>();

        for (var num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        var minHeap = new PriorityQueue<Integer>((a, b) -> freq.get(a) - freq.get(b));

        for (var key : freq.keySet()) {
            minHeap.offer(key);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        var result = new int[minHeap.size()];

        for (var i = 0; i < result.length; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
