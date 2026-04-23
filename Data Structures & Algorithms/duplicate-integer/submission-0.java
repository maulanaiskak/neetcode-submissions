class Solution {
    public boolean hasDuplicate(int[] nums) {
        var numsMap = new HashMap<Integer, Integer>();

        for (var num: nums) {
            var count = numsMap.getOrDefault(num, 0) + 1;
            numsMap.put(num, count);

            if (count > 1) {
                return true;
            }
        }

        return false;
    }
}