class Solution {
    public int findMin(int[] nums) {
        var left = 0;
        var right = nums.length - 1;

        // left < right bukan left <= right — hindari infinite loop
        // saat left == right, itu pasti minimum, langsung return
        while (left <= right) {
            if (left == right) {
                return nums[left];
            }
            
            var mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // mid ada di sisi kiri (bagian besar) — minimum pasti di kanan mid
                // mid sendiri bukan kandidat minimum, jadi left = mid + 1
                left = mid + 1;
            } else {
                // mid ada di sisi kanan (bagian kecil) — minimum ada di kiri atau mid itu sendiri
                // mid masih kandidat, jadi right = mid (bukan mid - 1)
                right = mid;
            }
        }

        // left == right, konvergen ke index minimum
        return nums[left];
    }
}