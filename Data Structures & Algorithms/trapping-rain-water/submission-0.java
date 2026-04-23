class Solution {
    public int trap(int[] height) {
        var prefix = new int[height.length];
        prefix[0] = height[0];
        var suffix = new int[height.length];
        suffix[height.length - 1] = height[height.length - 1];

        for (var i = 1; i < height.length; i++) {
            var j = height.length - 1 - i;
            prefix[i] = Math.max(height[i], prefix[i - 1]);
            suffix[j] = Math.max(height[j], suffix[j + 1]);
        }

        var total = 0;
        for (var i = 0; i < height.length; i++) {
            total += Math.min(prefix[i], suffix[i]) - height[i];
        }

        return total;
    }
}
