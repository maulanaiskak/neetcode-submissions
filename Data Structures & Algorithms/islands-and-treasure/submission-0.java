class Solution {
    static int MAX_VALUE = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        var queue = new ArrayDeque<int[]>();
        for (var row = 0; row < grid.length; row++) {
            for (var col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0) {
                    queue.offer(new int[]{row, col});
                }
            }
        }

        var directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            var value = queue.poll();

            for (var direction : directions) {
                var row = value[0] + direction[0];
                var col = value[1] + direction[1];

                if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
                    continue;
                }

                if (grid[row][col] == MAX_VALUE) {
                    grid[row][col] = grid[value[0]][value[1]] + 1;
                    queue.add(new int[]{row, col});
                }
            }
        }
    }
}
