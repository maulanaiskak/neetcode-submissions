class Solution {
    public void islandsAndTreasure(int[][] grid) {
        var queue = new ArrayDeque<int[]>();
        for (var row = 0; row < grid.length; row++) {
            for (var col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0) {
                    queue.offer(new int[]{row, col});
                }
            }
        }

        var dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            var cell = queue.poll();

            for (var dir : dirs) {
                var row = cell[0] + dir[0];
                var col = cell[1] + dir[1];

                if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length 
                    || grid[row][col] != Integer.MAX_VALUE) {
                    continue;
                }

                grid[row][col] = grid[cell[0]][cell[1]] + 1;
                queue.offer(new int[]{row, col});
            }
        }
    }
}
