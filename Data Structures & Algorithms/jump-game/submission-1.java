class Solution {
    public boolean canJump(int[] nums) {
        var maxReach = 0;

        for (var i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }

            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }
}
