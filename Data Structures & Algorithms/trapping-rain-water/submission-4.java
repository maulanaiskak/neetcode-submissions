class Solution {
    public int trap(int[] height) {
        var prefix = new int[height.length];
        prefix[0] = height[0];

        for (var i = 1; i < height.length; i++) {
            prefix[i] = Math.max(prefix[i - 1], height[i]);
        }

        var suffix = new int[height.length];
        suffix[height.length - 1] = height[height.length - 1];

        for (var i = height.length - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], height[i]);
        }

        var volume = 0;
        for (var i = 0; i < height.length; i++) {
            volume += Math.min(prefix[i], suffix[i]) - height[i];
        }

        return volume;
    }
}
