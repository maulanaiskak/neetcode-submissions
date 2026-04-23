class Solution {
    static int MAX_VALUE = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        var queue = new ArrayDeque<int[]>();

        // We need shortest distance from each land cell to its nearest treasure.
        // DFS won't work — it dives deep in one direction first, so it may find
        // a treasure 10 steps away before noticing one that's 2 steps away.
        // BFS processes cells level by level (distance by distance), so the first
        // time a cell is reached it's always via the shortest path.
        //
        // Naive approach: BFS from each INF cell separately = O(m*n) per cell
        // = O(m²*n²) total. Too slow.
        //
        // Better: flip the direction. Start BFS from ALL treasures at once
        // (multi-source BFS). Each treasure floods outward simultaneously.
        // Whichever wave hits an INF cell first = shortest distance.
        // Every cell is processed exactly once = O(m*n) total.
        for (var row = 0; row < grid.length; row++) {
            for (var col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0) {
                    queue.offer(new int[]{row, col});
                }
            }
        }

        var directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            var cell = queue.poll();

            for (var direction : directions) {
                var row = cell[0] + direction[0];
                var col = cell[1] + direction[1];

                if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
                    continue;
                }

                // Only process INF cells. Water (-1) is skipped automatically.
                // Cells already filled (< MAX_VALUE) are also skipped.
                // The distance value itself acts as the visited marker —
                // no separate visited array needed.
                if (grid[row][col] == MAX_VALUE) {
                    // Distance symmetry: "X is 3 steps from treasure" =
                    // "treasure is 3 steps from X". So expanding outward
                    // from treasure fills the correct answer automatically.
                    grid[row][col] = grid[cell[0]][cell[1]] + 1;
                    queue.add(new int[]{row, col});
                }
            }
        }
    }
}