class Solution {
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();

        for (var i = 0; i < nums.length; i++) {
            var num = nums[i];
            var complement = target - num;

            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }

            map.put(num, i);
        }

        return new int[0];
    }
}
