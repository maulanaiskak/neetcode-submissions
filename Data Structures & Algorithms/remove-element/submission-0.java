class Solution {
    public int removeElement(int[] nums, int val) {
        var k = 0;

        for (var num : nums) {
            if (num != val) {
                nums[k++] = num;
            }
        }

        return k;
    }
}