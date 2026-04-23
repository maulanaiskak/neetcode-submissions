class Solution {
    public int maxProduct(int[] nums) {
        // Max product subarray: at each i, track both max and min product ending at i.
        // Min is needed because negative * negative can become the new max.
        //
        // At each num, we have 3 candidates:
        // 1. num itself (start a new subarray)
        // 2. maxSoFar * num (extend current max subarray)
        // 3. minSoFar * num (extend current min subarray, useful if num is negative)
        //
        // We only need the previous max and min, so O(1) space suffices.
        // base: init maxSoFar and minSoFar to nums[0] (subarray must have at least 1 element)

        var minSoFar = nums[0];
        var maxSoFar = nums[0];
        var max = maxSoFar;

        for (var i = 1; i < nums.length; i++) {
            var candidate1 = nums[i];
            var candidate2 = maxSoFar * nums[i];
            var candidate3 = minSoFar * nums[i];

            maxSoFar = Math.max(candidate1, Math.max(candidate2, candidate3));
            minSoFar = Math.min(candidate1, Math.min(candidate2, candidate3));
            max = Math.max(max, maxSoFar);
        }

        return max;
    }
}
