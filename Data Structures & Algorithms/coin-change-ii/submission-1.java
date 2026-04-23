class Solution {
    public int change(int amount, int[] coins) {
        // We need to track "how many combinations exist for each sub-amount from 0..amount"
        // A single value is not enough — each amount[i] depends on amount[i-coin],
        // so we need the full history -> hence array dp[0..amount]
        var dp = new int[amount + 1];

        // Base case: there is exactly 1 way to make amount 0 — use no coins (empty combination)
        // if dp[0] = 0, all subsequent dp[i] would also be 0 (broken base case)
        dp[0] = 1;

        // Outer loop: coins — this ensures we count COMBINATIONS, not permutations
        // by committing to each coin before moving to the next,
        // [1,2] and [2,1] are never counted separately
        for (var coin : coins) {
            // Inner loop: amount — for each amount, accumulate how many ways
            // we can reach it using the current and previously seen coins
            for (var i = coin; i <= amount; i++) {
                // dp[i - coin] = combinations for the remaining amount after using this coin
                // we accumulate because multiple coins can contribute to the same amount
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}