class Solution {
    public int climbStairs(int n) {
        var prev2 = 1;
        var prev1 = 1;

        for (var i = 2; i <= n; i++) {
            var temp = prev1 + prev2;
            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }
}
