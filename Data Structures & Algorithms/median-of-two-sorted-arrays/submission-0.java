class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var merged = new ArrayList<Integer>();
        var i = 0;
        var j = 0;

        // Dua pointer independen, konsisten pakai i dan j
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                merged.add(nums1[i++]);
            } else {
                merged.add(nums2[j++]);
            }
        }

        // Append sisa — mulai dari i/j yang belum habis
        while (i < nums1.length) {
            merged.add(nums1[i++]);
        }
        
        while (j < nums2.length) {
            merged.add(nums2[j++]);
        }

        var size = merged.size();
        if (size % 2 != 0) {
            return merged.get(size / 2);
        } else {
            int mid = size / 2;
            return (merged.get(mid - 1) + merged.get(mid)) / 2.0;
        }
    }
}
