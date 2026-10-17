class Solution {
    public int maxProduct(int[] nums) {
        var result = nums[0];
        var max = nums[0];
        var min = nums[0];

        for (var i = 1; i < nums.length; i++) {
            var current = nums[i];
            var maxProduct = max * current;
            var minProduct = min * current;

            max = Math.max(current, Math.max(maxProduct, minProduct));
            min = Math.min(current, Math.min(maxProduct, minProduct));

            result = Math.max(result, max);
        }

        return result;
    }
}