class Solution {
    public int[] productExceptSelf(int[] nums) {
        var left = new int[nums.length];
        left[0] = 1;

        for (var i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        var right = new int[nums.length];
        right[nums.length - 1] = 1;

        for (var i = nums.length - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }
        
        var result = new int[nums.length];
        for (var i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }
}  
