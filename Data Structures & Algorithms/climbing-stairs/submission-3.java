class Solution {
    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }

        var first = 1;
        var second = 2;

        for (var i = 2; i < n; i++) {
            var sum = first + second;
            first = second;
            second = sum;
        }

        return second;
    }
}
