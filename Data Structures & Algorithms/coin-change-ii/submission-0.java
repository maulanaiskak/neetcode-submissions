class Solution {
    public int change(int amount, int[] coins) {
        var dp = new int[amount + 1];
        dp[0] = 1;

        for (var coin : coins) {
            for (var i = 1; i <= amount; i++){
                if (i - coin >= 0) {
                    dp[i] +=dp[i-coin];
                } 
            }
        }

        return dp[amount];
    }
}
