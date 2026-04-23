class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Binary search di array yang lebih pendek untuk efficiency
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int m    = nums1.length;
        int n    = nums2.length;
        int half = (m + n + 1) / 2; // jumlah elemen di sisi kiri partisi

        int left  = 0;
        int right = m;

        while (left <= right) {
            int partition1 = left + (right - left) / 2; // berapa elemen dari nums1 di kiri
            int partition2 = half - partition1;           // otomatis dari nums2

            // Nilai paling kanan di sisi kiri (atau -inf kalau partisi di ujung kiri)
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];

            // Nilai paling kiri di sisi kanan (atau +inf kalau partisi di ujung kanan)
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Partisi yang benar — semua kiri <= semua kanan
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeft1, maxLeft2); // total ganjil → max dari sisi kiri
                } else {
                    // Total genap → rata-rata max kiri dan min kanan
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
            } else if (maxLeft1 > minRight2) {
                right = partition1 - 1; // terlalu banyak dari nums1 di kiri
            } else {
                left = partition1 + 1;  // terlalu sedikit dari nums1 di kiri
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }
}
