class Solution {
    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();

        for (var num : nums) {
            set.add(num);
        }

        var maxLen = 0;
        for (var num : set) {
            if (!set.contains(num - 1)) {
                var length = 1;

                while (set.contains(num + length)) {
                    length++;
                }

                maxLen = Math.max(maxLen, length);
            }
        }

        return maxLen;
    }
}
