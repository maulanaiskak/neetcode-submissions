class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) heap.offer(f);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        int time = 0;

        while (!heap.isEmpty() || !queue.isEmpty()) {
            time++;

            if (!queue.isEmpty() && queue.peek()[1] == time) {
                heap.offer(queue.poll()[0]);
            }

            if (!heap.isEmpty()) {
                int count = heap.poll() - 1;
                if (count > 0) {
                    queue.offer(new int[]{count, time + n + 1});
                }
            }
        }

        return time;
    }
}