class Solution {
    public boolean canPartition(int[] nums) {
        var total = Arrays.stream(nums).sum();
        if (total % 2 != 0) {
            return false;
        }
        
        var target = total / 2;
        var dp = new boolean[target + 1];
        dp[0] = true;

        for (var num : nums) {
            for (var i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i-num];
            }
        }

        return dp[target];
    }
}
