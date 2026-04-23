class Solution {
    public int jump(int[] nums) {
        // Greedy BFS-like approach: treat each jump as a "level"
        // At each level, we know the range of indices reachable with the current number of jumps
        // We greedily find the farthest we can reach in the next jump
        var jumps = 0;
        // currentEnd = the farthest index reachable with `jumps` jumps so far
        var currentEnd = 0;
        // maxReach = the farthest index reachable if we take one more jump from anywhere in current level
        var maxReach = 0;

        // We stop at nums.length - 1 because once we reach the last index, we're done
        // If we include the last index, we might increment jumps unnecessarily
        for (var i = 0; i < nums.length - 1; i++) {
            // From index i, update the farthest we could reach with one more jump
            maxReach = Math.max(maxReach, i + nums[i]);

            // When i reaches the boundary of the current level,
            // we MUST take a jump to continue — increment jumps
            // and expand the boundary to maxReach (the farthest of the next level)
            if (i == currentEnd) {
                jumps++;
                currentEnd = maxReach;
            }
        }

        return jumps;
    }
}