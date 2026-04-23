class Solution {
    public boolean canPartition(int[] nums) {
        // If we can split nums into two equal subsets, each must sum to total/2.
        // So the problem reduces to: can we find a subset that sums to target?
        //
        // At each num, we ask: for each reachable sum i, can we reach i by including num?
        //   -> dp[i] = dp[i] (don't take num) || dp[i - num] (take num, check if remainder was reachable)
        //
        // Each num can only be used once, so we iterate i from target down to num.
        // If we go upward, dp[i - num] might already reflect the current num being used,
        // causing it to be counted more than once.
        //
        // e.g. nums=[1,5,11,5], target=11:
        //   num=1: dp[1]=true (0+1)
        //   num=5: dp[6]=true (1+5), dp[5]=true
        //   num=11: dp[11]=true
        //
        // base: dp[0] = true (sum 0 is always reachable by picking nothing)
        
        var sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        var target = sum / 2;
        var dp = new boolean[target + 1];
        dp[0] = true;

        for (var num : nums) {
            for (var i = target; i >= num; i--) {
                if (i - num >= 0) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }

        return dp[target];
    }
}
