class Solution {
    public int minCostClimbingStairs(int[] cost) {
        var prev = 0;
        var curr = 0;

        for (var i = 2; i <= cost.length; i++) {
            var temp = Math.min(cost[i - 1] + curr, cost[i - 2] + prev);
            prev = curr;
            curr = temp;
        }

        return curr;
    }
}
