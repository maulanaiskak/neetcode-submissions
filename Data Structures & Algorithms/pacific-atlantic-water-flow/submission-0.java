class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        var rows = heights.length;
        var cols = heights[0].length;

        // Instead of simulating water flowing downhill from each cell (O(m²n²)),
        // we reverse the problem: BFS uphill from each ocean's border.
        // Any cell reachable by both BFS sets can flow to both oceans.
        var pacificVisited = new boolean[rows][cols];
        var atlanticVisited = new boolean[rows][cols];

        var pacificQueue = new ArrayDeque<int[]>();
        var atlanticQueue = new ArrayDeque<int[]>();

        for (var row = 0; row < rows; row++) {
            for (var col = 0; col < cols; col++) {
                // Pacific borders top (row 0) and left (col 0)
                if (row == 0 || col == 0) {
                    pacificQueue.offer(new int[]{row, col});
                    pacificVisited[row][col] = true;
                }
                // Atlantic borders bottom (row m-1) and right (col n-1)
                if (row == rows - 1 || col == cols - 1) {
                    atlanticQueue.offer(new int[]{row, col});
                    atlanticVisited[row][col] = true;
                }
            }
        }

        // BFS uphill from each ocean's seed cells
        bfs(heights, pacificQueue, pacificVisited);
        bfs(heights, atlanticQueue, atlanticVisited);

        var result = new ArrayList<List<Integer>>();

        for (var row = 0; row < rows; row++) {
            for (var col = 0; col < cols; col++) {
                // Cell qualifies if reachable uphill from both oceans
                if (pacificVisited[row][col] && atlanticVisited[row][col]) {
                    result.add(List.of(row, col));
                }
            }
        }

        return result;
    }

    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void bfs(int[][] heights, ArrayDeque<int[]> queue, boolean[][] visited) {
        var rows = heights.length;
        var cols = heights[0].length;

        while (!queue.isEmpty()) {
            var cell = queue.poll();
            var currentRow = cell[0];
            var currentCol = cell[1];

            for (var dir : DIRS) {
                var neighborRow = currentRow + dir[0];
                var neighborCol = currentCol + dir[1];

                // Skip out-of-bounds
                if (neighborRow < 0 || neighborRow >= rows || neighborCol < 0 || neighborCol >= cols) {
                    continue;
                }

                // Skip already visited — prevents re-enqueuing and infinite loops
                if (visited[neighborRow][neighborCol]) {
                    continue;
                }

                // Only move uphill or flat — water flows down, so reversed BFS goes up (>=)
                if (heights[neighborRow][neighborCol] >= heights[currentRow][currentCol]) {
                    queue.offer(new int[]{neighborRow, neighborCol});
                    // Mark on enqueue, not on dequeue — prevents duplicate enqueues
                    visited[neighborRow][neighborCol] = true;
                }
            }
        }
    }
}