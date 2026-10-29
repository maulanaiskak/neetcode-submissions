class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // The goal is to reach the top of the staircase.
        // We can start at stair 0 or stair 1 and take either 1 or 2 steps at a time.
        // We pay the cost of a stair when stepping on it, but the top has no cost.
        // This is a Dynamic Programming problem because the minimum cost to reach 
        // the current stair depends on the minimum costs to reach the previous two stairs.
        // We reuse these results instead of recalculating them from scratch.
        
        // Base cases: the minimum cost to reach stair 0 or stair 1 is 0,
        // because we can start at either stair without paying any cost.
        // Base case: ground (stair 0) and stair 1.
        // The cost at stair 0 or 1 is 0.
        var prev2 = 0;
        var prev1 = 0;

        for (var i = 2; i <= cost.length; i++) {
            // Calculate the minimum cost to reach the current stair by either:
            // 1. Taking 1 step from the previous stair and paying its cost.
            // 2. Taking 2 steps from the stair before that and paying its cost.
            // Choose the option with the lower total cost.
            var temp = Math.min(prev1 + cost[i-1], prev2 + cost[i-2]);
            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }
}
