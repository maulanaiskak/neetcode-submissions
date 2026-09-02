class Solution {
    public int majorityElement(int[] nums) {
        var freq = new HashMap<Integer, Integer>();

        for (var num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for(var entry : freq.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }

        return -1;
    }
}