class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            var temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        var lo = 0;
        var hi = nums1.length;

        while (lo <= hi) {
            var i = (lo + hi) / 2;
            var j = (nums1.length + nums2.length + 1) / 2 - i;

            var nums1Left  = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            var nums1Right = (i == nums1.length) ? Integer.MAX_VALUE : nums1[i];
            var nums2Left  = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            var nums2Right = (j == nums2.length) ? Integer.MAX_VALUE : nums2[j];

            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                if ((nums1.length + nums2.length) % 2 == 1) {
                    return Math.max(nums1Left, nums2Left);
                } else {
                    return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
                }
            } else if (nums1Left > nums2Right) {
                hi = i - 1;
            } else {
                lo = i + 1;
            }
        }

        return -1;
    }
}
