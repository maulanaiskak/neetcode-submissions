class Solution {
    public int rob(int[] nums) {
        // This is an extension of House Robber I, but the houses are arranged in a circle.
        // Therefore, the first and last houses are adjacent, so we cannot rob both.
        // We can solve the problem by considering two scenarios:
        // 1. Rob houses from index 0 to n - 2, excluding the last house.
        // 2. Rob houses from index 1 to n - 1, excluding the first house.
        // The answer is the maximum amount from these two scenarios.

        if (nums.length < 2) {
            return nums.length == 1 ? nums[0] : 0;
        }

        var first = robHouse(Arrays.copyOfRange(nums, 0, nums.length - 1));
        var second = robHouse(Arrays.copyOfRange(nums, 1, nums.length));

        return Math.max(first, second);
        
    }

    public int robHouse(int[] nums) {
        // We cannot rob two adjacent houses.
        // For example, given [1, 1, 3, 3], if we rob house 0, we cannot rob house 1.
        // At each house, we have two choices:
        // 1. Rob the current house and add its value to the maximum amount from two houses back.
        // 2. Skip the current house and keep the maximum amount from the previous house.

        // We choose the option that gives us the maximum amount.
        // This is a Dynamic Programming problem because the optimal result for the current house
        // depends on the results of the previous two houses.

        if (nums.length < 2) {
            return nums.length == 1 ? nums[0] : 0;
        }
        
        // Base case: if there is only one house, rob it.
        var prev2 = nums[0];

        // Base case: for the first two houses, rob the one with the higher value.
        // We cannot rob both because they are adjacent.
        var prev1 = Math.max(nums[0], nums[1]);

        for (var i = 2; i < nums.length; i++) {
            // Calculate the maximum amount by either robbing the current house
            // and adding its value to prev2, or skipping it and keeping prev1.
            var temp = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }
}
