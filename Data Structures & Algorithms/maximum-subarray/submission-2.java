class Solution {
    public int maxSubArray(int[] nums) {
        // Track running sum, reset to 0 if negative (negative prefix only drags down future sum)
        // Example: [2, -3, 4, -2, 2, 1, -1, 4]
        // idx 0: curr=2,  max=2
        // idx 1: curr=-1, max=2,  curr<0 -> reset to 0
        // idx 2: curr=4,  max=4
        // idx 3: curr=2,  max=4
        // idx 4: curr=4,  max=4
        // idx 5: curr=5,  max=5
        // idx 6: curr=4,  max=5
        // idx 7: curr=8,  max=8

        var current = 0;
        var max = nums[0];

        for (var num : nums) {
            current += num;
            max = Math.max(current, max);

            if (current < 0) {
                current = 0;
            }
        }

        return max;
    }
}