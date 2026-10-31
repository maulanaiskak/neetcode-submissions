class Solution {
    public int lengthOfLIS(int[] nums) {
        // To find the longest increasing subsequence,
        // we can build the answer from left to right.
        //
        // Example:
        // [10, 9, 2, 5, 3, 7, 101, 18]
        //
        // dp[i] represents the length of the longest increasing
        // subsequence that ends at index i.
        //
        // Each element can form a subsequence by itself,
        // so the minimum length is 1.
        var dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (var i = 0; i < nums.length; i++) {
            // Check all elements before the current index.
            for (var j = 0; j < i; j++) {
                // We can extend the subsequence ending at j
                // if nums[j] is smaller than the current number.
                if (nums[i] > nums[j]) {
                    // Add the current number to the subsequence ending at j.
                    // Compare it with the current best length at index i
                    // because there might be another longer subsequence.
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // The LIS can end at any index, not necessarily the last one.
        // Therefore, return the maximum value across the entire dp array.
        return Arrays.stream(dp).max().getAsInt();
    }
}