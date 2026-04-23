class Solution {
    public int[] productExceptSelf(int[] nums) {
        var result = new int[nums.length];
        
        // Build left products in result
        result[0] = 1;
        for (var i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // Multiply with right products on-the-fly
        var rightProduct = 1;
        for (var i = nums.length - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        
        return result;
    }
}  
