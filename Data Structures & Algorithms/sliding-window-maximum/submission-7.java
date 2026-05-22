class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        var result = new int[nums.length - k + 1];
        var heap = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));

        for (var i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
            
            if (i >= k) {
                heap.remove(nums[i - k]);
            }

            if (i >= k - 1) {
                result[i - k + 1] = heap.peek();
            }
        }

        return result;
    }
}
