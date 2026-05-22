class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        var result = new int[nums.length - k + 1];
        var deque = new ArrayDeque<Integer>();

        for (var i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);

            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
