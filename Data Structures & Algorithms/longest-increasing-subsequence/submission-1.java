class Solution {
    public int lengthOfLIS(int[] nums) {
        // To find LIS, at each index i we need to know the longest increasing subsequence
        // that can be extended by nums[i]. This requires knowing results for all j < i,
        // so we cache them — that's why we use DP.
        //
        // dp[i] = length of longest increasing subsequence ending at index i.
        //
        // For each i, try all previous positions j where nums[j] < nums[i]:
        //   -> dp[i] = max(dp[i], dp[j] + 1) (extend the subsequence ending at j)
        //
        // Unlike subarray problems, LIS can skip elements, so we check all j < i, not just j = i-1.
        //
        // e.g. nums=[2,5,3,7]:
        //   i=1 (5): j=0, 5>2 -> dp[1]=2
        //   i=2 (3): j=0, 3>2 -> dp[2]=2
        //   i=3 (7): j=0,1,2 -> dp[3]=3
        //
        // answer = max across all dp[i] (LIS can end anywhere)
        // base: dp[i] = 1 (every element is a subsequence of length 1)

        var dp = new int[nums.length];
        dp[0] = 1;
        var max = 1;

        for (var i = 1; i < nums.length; i++) {
            dp[i] = 1;
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
