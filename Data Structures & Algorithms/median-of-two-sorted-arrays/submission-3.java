class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var merged = new int[nums1.length + nums2.length];

        for (var i = 0; i < nums1.length; i++) {
            merged[i] = nums1[i];
        }

        for (var i = 0; i < nums2.length; i++) {
            merged[i + nums1.length] = nums2[i];
        }

        Arrays.sort(merged);
        var mid = merged.length / 2;

        if (merged.length %2 == 0) {
            return (merged[mid] + merged[mid - 1]) / 2.0;
        } else {
            return merged[mid];
        }
    }
}
