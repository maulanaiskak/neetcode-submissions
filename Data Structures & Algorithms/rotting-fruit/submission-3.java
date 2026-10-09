class Solution {
    public int orangesRotting(int[][] grid) {
        var queue = new ArrayDeque<int[]>();
        var fresh = 0;
        for (var row = 0; row < grid.length; row++) {
            for (var col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                }

                if (grid[row][col] == 1) {
                    fresh++;
                }
            }
        }

        var dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        var minutes = 0;

        while (!queue.isEmpty() && fresh > 0) {
            var size = queue.size();

            for (var i = 0; i < size; i++) {
                var cell = queue.poll();

                for (var dir : dirs) {
                    var row = cell[0] + dir[0];
                    var col = cell[1] + dir[1];

                    if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 1) {
                        continue;
                    }

                    grid[row][col] = 2;
                    fresh--;
                    queue.offer(new int[]{row, col});
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
