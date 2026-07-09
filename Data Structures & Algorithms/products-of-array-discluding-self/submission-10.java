class Solution {
    public int[] productExceptSelf(int[] nums) {
        var leftProduct = new int[nums.length];
        leftProduct[0] = 1;

        for (var i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }

        var result = new int[nums.length];
        var right = 1;

        for (var i = nums.length - 1; i >= 0; i--) {
            result[i] = leftProduct[i] * right;
            right *= nums[i];
        }

        return result;
    }
}  
