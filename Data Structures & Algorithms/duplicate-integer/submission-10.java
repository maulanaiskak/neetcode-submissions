class Solution {
    public boolean hasDuplicate(int[] nums) {
        var numSet = new HashSet<Integer>();

        for (var num : nums) {
            if (!numSet.add(num)) {
                return true;
            }
        }

        return false;
    }
}