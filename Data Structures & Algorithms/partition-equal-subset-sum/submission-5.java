class Solution {
public boolean canPartition(int[] nums) {
// To partition the array into two subsets with equal sums,
// we need to find a subset whose sum equals half of the total sum.
//
// Example:
// [3, 1, 4, 2]
// Total sum = 10
// Target = 5
//
// If we can find a subset with sum 5,
// the remaining elements will also have sum 5.
var total = Arrays.stream(nums).sum();

    // If the total sum is odd, we cannot split it into two equal sums.
    if (total % 2 != 0) {
        return false;
    }
    var target = total / 2;
    // dp[i] represents whether we can form sum i
    // using the numbers that we have processed so far.
    //
    // Initially, we can only form sum 0
    // by not picking any numbers.
    var dp = new boolean[target + 1];
    dp[0] = true;
    // Process each number one by one.
    for (var num : nums) {
        // Check possible sums from target down to the current number.
        // We iterate backwards to ensure each number is used only once.
        for (var i = target; i >= num; i--) {
            // We can form sum i if:
            // 1. We could already form sum i without the current number.
            // 2. We could form sum (i - num) before, then add the current number.
            dp[i] = dp[i] || dp[i - num];
        }
    }
    // If dp[target] is true, we found a subset with the target sum.
    return dp[target];
}

}