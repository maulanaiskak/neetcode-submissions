class Solution {
    public int[] twoSum(int[] nums, int target) {
        var complementMap = new HashMap<Integer, Integer>();

        for (var i = 0; i < nums.length; i++) {
            var complement = target - nums[i];

            if (complementMap.containsKey(complement)) {
                return new int[]{complementMap.get(complement), i};
            }

            complementMap.put(nums[i], i);
        }

        return new int[]{};
    }
}
