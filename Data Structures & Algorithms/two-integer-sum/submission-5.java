class Solution {
    public int[] twoSum(int[] nums, int target) {
        var numToIdx = new HashMap<Integer, Integer>();

        for (var i = 0; i < nums.length; i++) {
            var complement = target - nums[i];

            if (numToIdx.containsKey(complement)) {
                return new int[]{numToIdx.get(complement), i};
            }

            numToIdx.put(nums[i], i);
        }

        return new int[0];
    }
}
