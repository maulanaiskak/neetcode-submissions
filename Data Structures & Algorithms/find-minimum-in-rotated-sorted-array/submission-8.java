class Solution {
    public int findMin(int[] nums) {
        var left = 0;
        var right = nums.length - 1;

        while (left < right) {
            var mid = (left + right) / 2;

            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
    }
}
