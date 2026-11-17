class Solution {
    public int longestConsecutive(int[] nums) {
        var numSet = new HashSet<Integer>(nums.length);
        for (var num : nums) {
            numSet.add(num);
        }

        var max = 0;

        for (var num : nums) {
            if (!numSet.contains(num - 1)) {
                var len = 1;

                while (numSet.contains(num + len)) {
                    len++;
                }

                max = Math.max(max, len);
            }
        }

        return max;
    }
}
