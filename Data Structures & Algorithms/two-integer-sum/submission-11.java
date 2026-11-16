class Solution {
    public int[] twoSum(int[] nums, int target) {
        var seen = new HashMap<Integer, Integer>();

        for (var i = 0; i < nums.length; i++) {
            var complement = target - nums[i];

            if (seen.containsKey(complement)) {
                return new int[] {seen.get(complement), i};
            }

            seen.put(nums[i], i);
        }

        return new int[0];
    }
}
