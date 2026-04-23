class Solution {
    public int[] twoSum(int[] nums, int target) {
        var result = new int[2];
        var diffMap = new HashMap<Integer, Integer> ();

        for (var i = 0; i < nums.length; i++) {
            var savedIndex = diffMap.get(nums[i]);
            if (savedIndex != null) {
                result[0] = savedIndex;
                result[1] = i;
                break;
            }

            diffMap.put(target - nums[i], i);
        }

        return result;
    }
}
