class Solution {
    public int[] productExceptSelf(int[] nums) {
        var result = new int[nums.length];
        result[0] = 1;

        for (var i = 1; i < nums.length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }

        var suffix = 1;

        for (var i = nums.length - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }
}  
