class Solution {
    public int climbStairs(int n) {
        // The goal is to reach the top of staircase n.
        // We can take either 1 or 2 steps at a time. For stair 2, there are 2 ways:
        // jump directly from stair 0 to stair 2, or take 1 step at a time through stair 1.
        // This is a Dynamic Programming problem because the number of ways to reach 
        // the current stair depends on the results of the previous two stairs.
        // We reuse these results instead of recalculating them from scratch.

        // Base case: ground (stair 0).
        // There is 1 way to be at the ground: do nothing.
        var prev2 = 1;

        // Base case: stair 1.
        // There is 1 way to reach stair 1: take 1 step from the ground.
        var prev1 = 1;

        for (var i = 2; i <= n; i++) {
            // The number of ways to reach the current stair depends on the previous two stairs.
            // Since we can take either 1 or 2 steps at a time, we add prev1 and prev2.
            var temp = prev1 + prev2;
            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }
}
