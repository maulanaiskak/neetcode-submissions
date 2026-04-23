class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // we can make a map to count the frequency of each num
        // then we can use heap to get the top 2 values

        var frequency = new HashMap<Integer, Integer>();

        for (var num : nums) {
            frequency.merge(num, 1, Integer::sum);
        }

        var mostFrequent = new PriorityQueue<Integer>((a, b) -> frequency.get(a) - frequency.get(b));

        for (var key : frequency.keySet()) {
            mostFrequent.add(key);

            if (mostFrequent.size() > k) {
                mostFrequent.poll();
            }
        }

        return mostFrequent.stream().mapToInt(Integer::intValue).toArray();
    }
}
