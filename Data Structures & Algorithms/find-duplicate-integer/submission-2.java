class Solution {
    public int findDuplicate(int[] nums) {
        var set = new HashSet<Integer>();

        for (var num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }

        return -1;
    }
}
