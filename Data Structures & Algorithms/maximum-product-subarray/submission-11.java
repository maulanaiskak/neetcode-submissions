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

        var result = nums[0];
        var max = nums[0];
        var min = nums[0];

        for (var i = 1; i < nums.length; i++) {
            var tempMax = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            var tempMin = Math.min(nums[i], Math.min(nums[i] * max, nums[i] * min));
            result = Math.max(tempMax, result);
            max = tempMax;
            min = tempMin;
        }

        return result;
    }
}
