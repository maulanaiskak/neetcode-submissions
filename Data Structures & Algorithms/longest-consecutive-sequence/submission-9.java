class Solution {
    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        for (var num : nums) {
            set.add(num);
        }

        var longest = 0;

        for (var num : nums) {
            if (!set.contains(num - 1)) {
                var length = 1;

                while (set.contains(num + length)) {
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
