class Solution {
    public int search(int[] nums, int target) {
        var left = 0;
        var right = nums.length - 1;

        while (left <= right) {
            var mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // ketemu
            } else if (nums[left] <= nums[mid]) {
                // sisi kiri sorted (left sampai mid ascending)
                if (nums[left] <= target && target < nums[mid]) {
                    // target ada di range kiri yang sorted
                    right = mid - 1;
                } else {
                    // target di luar range kiri, cari di kanan
                    left = mid + 1;
                }
            } else {
                // sisi kanan sorted (mid sampai right ascending)
                if (nums[mid] < target && target <= nums[right]) {
                    // target ada di range kanan yang sorted
                    left = mid + 1;
                } else {
                    // target di luar range kanan, cari di kiri
                    right = mid - 1;
                }
            }
        }

        return -1; // target ga ada
    }
}