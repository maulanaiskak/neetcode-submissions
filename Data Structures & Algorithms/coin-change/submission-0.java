class Solution {
    public int coinChange(int[] coins, int amount) {
        // Coin change is a DP problem: dp[i] = min coins needed to make amount i
        //
        // We can look back because we iterate i from 1 to amount,
        // so dp[i - coin] is always already computed when we need it.
        // e.g. coins = [1, 2, 5], amount = 6:
        //   dp[6] tries coin=5 -> reuses dp[1] (already computed at i=1)
        //   dp[6] tries coin=2 -> reuses dp[4] (already computed at i=4)
        //
        // For each amount i, try every coin:
        //   if i - coin >= 0: dp[i] = min(dp[i], dp[i - coin] + 1)
        //
        // base: dp[0] = 0 (0 coins needed to make amount 0)
        // init: dp[i] = amount + 1 (sentinel for "unreachable", max coins needed <= amount)
        // sorting coins is not needed: we try all coins for every amount regardless of order

        var dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (var i = 1; i <= amount; i++) {
            for (var coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
