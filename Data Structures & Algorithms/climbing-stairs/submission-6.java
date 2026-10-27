class Solution {
    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }

        var prev = 1;
        var curr = 2;

        for (var i = 2; i < n; i++) {
            var temp = prev + curr;
            prev = curr;
            curr = temp;
        }

        return curr;
    }
}