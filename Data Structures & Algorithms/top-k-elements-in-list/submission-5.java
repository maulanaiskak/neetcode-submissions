class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var freq = new HashMap<Integer, Integer>();

        for (var i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        var minHeap = new PriorityQueue<Integer>((a, b) -> freq.get(a) - freq.get(b));

        for (var num : freq.keySet()) {
            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        var result = new int[k];
        for (var i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
