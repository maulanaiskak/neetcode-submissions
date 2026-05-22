class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        var result = new int[nums.length - k + 1];
        var left = 0;
        var right = k - 1;

        while (right < nums.length) {
            var max = Integer.MIN_VALUE;;
            for (var i = left; i <= right; i++) {
                max = Math.max(max, nums[i]);
            }

            result[left] = max;
            left++;
            right++;
        }

        return result;
    }
}
