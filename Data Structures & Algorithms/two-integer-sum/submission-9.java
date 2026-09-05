class Solution {
    public int[] twoSum(int[] nums, int target) {
        var indexes = new HashMap<Integer, Integer>();
        
        for (var i = 0; i < nums.length; i++) {
            var complement = target - nums[i];

            if (indexes.containsKey(complement)) {
                return new int[]{indexes.get(complement), i};
            }

            indexes.put(nums[i], i);
        }

        return new int[]{};
    }
}
