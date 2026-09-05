class Solution {
    public int[] productExceptSelf(int[] nums) {
        var prefix = new int[nums.length];
        prefix[0] = 1;

        for (var i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        
        var suffix = new int[nums.length];
        suffix[nums.length - 1] = 1;

        for (var i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (var i = 0; i < nums.length; i++) {
            prefix[i] *= suffix[i];
        }

        return prefix;
    }
}  
