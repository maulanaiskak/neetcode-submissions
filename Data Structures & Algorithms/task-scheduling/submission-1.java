class Solution {
    public int leastInterval(char[] tasks, int n) {
        var freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        var maxHeap = new PriorityQueue<Character>((a, b) -> freq[b - 'A'] - freq[a - 'A']);

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer((char) ('A' + i));
            }
        }

        var queue = new ArrayDeque<int[]>();
        int time = 0;

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;

            if (!queue.isEmpty() && queue.peek()[1] == time) {
                maxHeap.offer((char) queue.poll()[0]);
            }
            
            if (!maxHeap.isEmpty()) {
                char c = maxHeap.poll();
                freq[c - 'A']--;

                if (freq[c - 'A'] > 0) {
                    queue.offer(new int[]{c, time + n + 1});
                }
            }

        }

        return time;
    }
}
