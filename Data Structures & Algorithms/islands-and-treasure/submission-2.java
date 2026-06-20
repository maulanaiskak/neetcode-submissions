class Solution {
    private static Integer MAX_VALUE = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        if (grid.length == 0) {
            return;
        }

        var deque = new ArrayDeque<int[]>();
        for (var row = 0; row < grid.length; row ++) {
            for (var col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0) {
                    deque.offer(new int[]{row, col});
                }
            }
        }

        var dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!deque.isEmpty()) {
            var size = deque.size();

            for (var i = 0; i < size; i++) {
                var cell = deque.poll();

                for (var d : dir) {
                    var row = cell[0] + d[0];
                    var col = cell[1] + d[1];

                    if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
                        continue;
                    }

                    var value = grid[row][col];

                    if (MAX_VALUE.equals(value)) {
                        grid[row][col] = grid[cell[0]][cell[1]] + 1;
                        deque.offer(new int[]{row, col});
                    }
                }
            }
        }
    }
}
