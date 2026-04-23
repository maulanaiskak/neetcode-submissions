class Solution {
    public boolean canJump(int[] nums) {
        // Greedy approach: track the farthest index reachable at any point
        // We don't need to know the exact path, just whether the end is reachable
        // Key insight: if we can reach index i, we can reach any index up to i + nums[i]
        var maxReach = 0;

        for (var i = 0; i < nums.length; i++) {
            // If current index is beyond what we can reach, we're stuck
            // This happens when nums[i] = 0 and no previous jump can skip over it
            if (i > maxReach) return false;

            // Update farthest reachable index from current position
            // We take max because a previous index might have reached farther
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        // If we finished the loop without getting stuck, the end is reachable
        return true;
    }
}