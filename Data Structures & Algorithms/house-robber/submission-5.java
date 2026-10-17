class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        var prev = nums[0];
        var curr = Math.max(nums[0], nums[1]);

        for (var i = 2; i < nums.length; i++) {
            var temp = Math.max(prev + nums[i], curr);
            prev = curr;
            curr = temp;
        }

        return curr;
    }
}
