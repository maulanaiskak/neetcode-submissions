class Solution {
    public int coinChange(int[] coins, int amount) {
        // To find the minimum number of coins, we can try using each
        // available coin to make up the current amount.
        
        // Example: amount = 6, coins = [1, 2, 5]
        // 6 = 1 + 1 + 1 + 1 + 1 + 1 -> 6 coins
        // 6 = 2 + 2 + 2             -> 3 coins
        // 6 = 5 + 1                 -> 2 coins (minimum)
        
        // dp[i] represents the minimum number of coins needed to make amount i.
        // For each coin, if we can use it to make amount i, we check:
        // dp[i - coin] + 1
        // This means making the remaining amount first, then adding one coin.
        // We take the minimum among all possible choices.

        var dp = new int[amount + 1];

        // Initialize with an impossible value because the minimum is unknown.
        Arrays.fill(dp, amount + 1);

        // Base case: amount 0 requires 0 coins.
        dp[0] = 0;

        for (var i = 1; i <= amount; i++) {
            for (var coin : coins) {
                if (i >= coin) {
                    // Compare the current minimum (dp[i]) with using this coin.
                    // dp[i - coin] represents the minimum coins needed for the remaining amount.
                    // +1 because we use one additional coin to make up the current amount.
                    // Take the minimum to find the best choice among all available coins.
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still unchanged, the amount cannot be formed.
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}