class Solution {
    public int orangesRotting(int[][] grid) {
        var rottens = new ArrayDeque<int[]>();
        var freshCount = 0;

        // The problem says rotting spreads simultaneously every minute —
        // "simultaneously" is the key word. This maps directly to BFS level-by-level
        // traversal, where one level = one minute. DFS wouldn't work here because
        // it explores one path deeply first, which can't model simultaneous spreading.
        //
        // Multi-source BFS: instead of BFS from each rotten orange separately
        // (which would be O(r * m*n) where r = rotten count), we enqueue ALL
        // rotten oranges upfront and let them spread in parallel. This gives O(m*n).
        for (var row = 0; row < grid.length; row++) {
            for (var col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    rottens.offer(new int[]{row, col});
                }

                // Track fresh count so we can detect unreachable fresh oranges at the end.
                if (grid[row][col] == 1) {
                    freshCount++;
                }
            }
        }

        var directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        var totalTime = 0;

        while (!rottens.isEmpty()) {
            // Snapshot the current level size before polling.
            // Everything currently in the queue belongs to the same "minute".
            // Newly added oranges (freshly rotted) belong to the next minute.
            var size = rottens.size();
            var isRotted = false;

            for (var i = 0; i < size; i++) {
                var value = rottens.poll();

                for (var direction : directions) {
                    var row = value[0] + direction[0];
                    var col = value[1] + direction[1];

                    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
                        continue;
                    }

                    // Only spread to fresh oranges. Already rotten ones are skipped
                    // automatically — this also serves as the visited check,
                    // so no separate visited array is needed.
                    if (grid[row][col] == 1) {
                        grid[row][col] = 2;
                        isRotted = true;
                        freshCount--;
                        rottens.offer(new int[]{row, col});
                    }
                }
            }

            // Only count this minute if at least one fresh orange actually rotted.
            // Without this guard, the last level (where rotten oranges have no
            // fresh neighbors left) would still increment totalTime, causing off-by-one.
            if (isRotted) {
                totalTime++;
            }
        }

        // If fresh oranges remain, they were isolated by water cells or empty cells
        // and can never be reached — return -1.
        return freshCount > 0 ? -1 : totalTime;
    }
}