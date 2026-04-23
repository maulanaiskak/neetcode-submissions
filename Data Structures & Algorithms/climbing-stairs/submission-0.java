class Solution {
    public int climbStairs(int n) {
        var prev = 1;
        var curr = 1;

        for (var i = 2; i <= n; i++) {
            var temp = prev + curr;
            prev = curr;
            curr = temp;
        }

        return curr;
    }
}
