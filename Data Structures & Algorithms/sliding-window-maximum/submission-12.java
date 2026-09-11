class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        var result = new int[nums.length - k + 1];
        var deque = new ArrayDeque<Integer>();
        var left = 0;

        for (var right = 0; right < nums.length; right++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }

            deque.offer(right);

            if (deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }

            if (right >= k - 1) {
                result[right - k + 1] = nums[deque.peekFirst()];
            }
            
        }

        return result;
    }
}
