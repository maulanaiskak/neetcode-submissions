class Solution {
    public boolean hasDuplicate(int[] nums) {
        var set = new HashSet<Integer>();

        for (var num : nums) {
            set.add(num);
        }

        return set.size() != nums.length;
    }
}