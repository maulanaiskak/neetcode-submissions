class Solution {
    public int findKthLargest(int[] nums, int k) {
        var maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for (var num : nums) {
            maxHeap.offer(num);
        }

        var result = 0;
        for (var i = 0; i < k; i++) {
            result = maxHeap.poll();
        }

        return result;
    }
}
