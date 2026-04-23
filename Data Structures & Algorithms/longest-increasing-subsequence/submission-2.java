class Solution {
    public int lengthOfLIS(int[] nums) {
        // At each index i, we want the longest increasing subsequence ending at nums[i].
        // To avoid recomputing, we cache the result for every index as we go.
        //
        // For each i, scan all j < i where nums[j] < nums[i]:
        //   -> best length ending at i = max(best length ending at j) + 1
        //
        // LIS can skip elements, so we must check all j < i, not just j = i-1.
        //
        // e.g. nums=[9,1,4,2,3,3,7]:
        //   i=2 (4): 4>1 -> reuse cached result at j=1, length=2
        //   i=4 (3): 3>2 -> reuse cached result at j=3, length=3
        //   i=6 (7): 7>3 -> reuse cached result at j=4, length=4
        //
        // answer = max across all cached results (LIS can end anywhere)
        // base: every element is a subsequence of length 1

        var dp = new int[nums.length];
        Arrays.fill(dp, 1);
        var max = 1;

        for (var i = 1; i < nums.length; i++) {
            for (var j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max;
    }
}
