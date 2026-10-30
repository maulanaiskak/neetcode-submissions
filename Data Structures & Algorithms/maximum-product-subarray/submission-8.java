class Solution {
    public int maxProduct(int[] nums) {
        // To find the maximum product subarray, we iterate through the array
        // and calculate the maximum product ending at each position.

        // The tricky part is negative numbers.
        // Multiplying two negative numbers produces a positive number.
        // Therefore, we need to track both maximum and minimum products.

        // Example: nums = [-2, 3, -4]
        // [-2]       = -2
        // [-2, 3]    = -6
        // [-2, 3,-4] = 24 (maximum)

        // maxProduct represents the maximum product of a subarray
        // that ends at the current position.

        // minProduct represents the minimum product of a subarray
        // that ends at the current position.
        // We need this because a negative number can turn
        // the minimum product into the maximum product.

        var maxProduct = nums[0];
        var minProduct = nums[0];

        // Store the maximum product found across all positions.
        var result = nums[0];

        for (var i = 1; i < nums.length; i++) {
            var num = nums[i];

            // There are three possibilities:
            // 1. Start a new subarray from the current number.
            // 2. Extend the previous maximum product.
            // 3. Extend the previous minimum product.
            //
            // We compare all three to find the new maximum product.
            var tempMax = Math.max(
                num,
                Math.max(maxProduct * num, minProduct * num)
            );

            // Similarly, find the new minimum product.
            // We need to keep track of it because a negative number
            // in the next iteration might turn it into a maximum.
            var tempMin = Math.min(
                num,
                Math.min(maxProduct * num, minProduct * num)
            );

            // Update both states.
            // Use temporary variables because both calculations
            // must use the previous iteration's values.
            maxProduct = tempMax;
            minProduct = tempMin;

            // Compare the maximum product ending at this position
            // with the best result found so far.
            result = Math.max(result, maxProduct);
        }

        return result;
    }
}