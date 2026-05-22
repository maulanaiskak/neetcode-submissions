class Solution {
    public int leastInterval(char[] tasks, int n) {
        var freq = new HashMap<Character, Integer>();

        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        // max heap by remaining count
        var maxHeap = new PriorityQueue<Integer>(
            Comparator.reverseOrder()
        );

        for (int count : freq.values()) {
            maxHeap.offer(count);
        }

        // [remainingCount, availableTime]
        var queue = new ArrayDeque<int[]>();

        int time = 0;

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;

            // execute task
            if (!maxHeap.isEmpty()) {
                int count = maxHeap.poll();
                count--;

                if (count > 0) {
                    queue.offer(new int[]{count, time + n});
                }
            }

            // cooldown finished
            if (!queue.isEmpty() && queue.peek()[1] == time) {
                maxHeap.offer(queue.poll()[0]);
            }
        }

        return time;
    }
}