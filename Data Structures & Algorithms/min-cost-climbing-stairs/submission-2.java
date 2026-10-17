class Solution {
    public int minCostClimbingStairs(int[] cost) {
        var prev = 0;
        var curr = 0;

        for (var i = 2; i <= cost.length; i++) {
            var temp = Math.min(curr + cost[i-1], prev + cost[i-2]);
            prev = curr;
            curr = temp;
        }

        return curr;
    }
}
