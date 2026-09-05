class Solution {
    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        var longest = 0;

        for (var num : nums) {
            set.add(num);
        }

        for (var num : nums) {
            if (!set.contains(num - 1)) {
                var current = num;
                var length = 1;

                while (set.contains(current + 1)) {
                    current += 1;
                    length += 1;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
