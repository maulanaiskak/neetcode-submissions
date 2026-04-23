class Solution {
    public int[] twoSum(int[] nums, int target) {
        // if we have a + b = c, we can get a = c - b;
        // then we can save the complement to the map
        // find the complement in the map, if exist return. if no put current number to map

        Map<Integer, Integer> complementMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (complementMap.get(complement) != null) {
                return new int[]{complementMap.get(complement), i};
            }

            complementMap.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
