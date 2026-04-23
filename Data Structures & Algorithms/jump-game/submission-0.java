class Solution {
    public boolean canJump(int[] nums) {
        return dp(nums, 0);
    }

    private boolean dp(int[] nums, int i) {
        if (i >= nums.length - 1) {
            return true;
        }

        for (var jump = 1; jump <= nums[i]; jump++) {
            if (dp(nums, i + jump)) return true;
        }
        return false;
    }
}
