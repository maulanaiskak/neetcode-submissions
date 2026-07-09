class Solution {
    public int longestConsecutive(int[] nums) {
        var numSet = new HashSet<Integer>();
        var maxStreak = 0;

        for (var num : nums) {
            numSet.add(num);
        }

        for (var num : nums) {
            if (!numSet.contains(num - 1)) {
                var streak = 1;

                while (numSet.contains(num + streak)) {
                    streak++;
                }

                maxStreak = Math.max(maxStreak, streak);
            }
        }

        return maxStreak;
    }
}
