class Solution {
    public int[] productExceptSelf(int[] nums) {
        var result = new int[nums.length];
        var left = new int[nums.length];
        left[0] = 1;

        for (var i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        var right = 1;
        for (var i = nums.length - 1; i >= 0; i--) {
            result[i] = left[i] * right;
            right *= nums[i];
        }

        return result;
    }
}  
