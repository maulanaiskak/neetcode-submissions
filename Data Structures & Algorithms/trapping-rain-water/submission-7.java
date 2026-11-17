class Solution {
    public int trap(int[] height) {
        var left = new int[height.length];
        var right = new int[height.length];
        var n = height.length;

        for (var i = 0; i < n; i++) {
            left[i] = i == 0
                ? height[i]
                : Math.max(left[i - 1], height[i]);

            right[n - 1 - i] = i == 0
                ? height[n - 1]
                : Math.max(right[n - i], height[n - 1 - i]);
        }

        var total = 0;

        for (var i = 0; i < n; i++) {
            total += Math.min(left[i], right[i]) - height[i];
        }

        return total;
    }
}
