class Solution {
    public int search(int[] nums, int target) {
        var left = 0;
        var right = nums.length - 1;

        while (left <= right) {
            var mid = left + (right - left) / 2;
            var midValue = nums[mid];

            if (midValue == target) {
                return mid;
            }
            
            // Check which part is sorted
            if (nums[left] <= nums[mid]) {
                // Left part is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    // Target is in sorted left part
                    right = mid - 1;
                } else {
                    // Target is in right part
                    left = mid + 1;
                }
            } else {
                // Right part is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    // Target is in sorted right part
                    left = mid + 1;
                } else {
                    // Target is in left part
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
