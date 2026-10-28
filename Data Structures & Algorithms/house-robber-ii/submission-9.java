class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        
        var first = robHouse(Arrays.copyOfRange(nums, 0, nums.length - 1));
        var second = robHouse(Arrays.copyOfRange(nums, 1, nums.length));

        return Math.max(first, second);
    }

    private int robHouse(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        var prev2 = nums[0];
        var prev1 = Math.max(nums[0], nums[1]);

        for (var i = 2; i < nums.length; i++) {
            var curr = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
