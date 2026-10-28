class Solution {
    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        
        var prev2 = 1;
        var prev1 = 2;

        for (var i = 2; i < n; i++) {
            var curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
