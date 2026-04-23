class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        return Math.max(
            robHouse(Arrays.copyOfRange(nums, 0, nums.length - 1)), 
            robHouse(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int robHouse(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        var prev = nums[0];
        var curr = Math.max(nums[0], nums[1]);

        for (var i = 2; i < nums.length; i++) {
            var temp = Math.max(curr, nums[i] + prev);
            prev = curr;
            curr = temp;
        }

        return curr;
    }
}
