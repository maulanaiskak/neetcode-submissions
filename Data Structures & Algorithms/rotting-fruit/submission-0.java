class Solution {
    public int orangesRotting(int[][] grid) {
        var rottens = new ArrayDeque<int[]>();
        var freshCount = 0;

        for (var row = 0; row < grid.length; row++) {
            for (var col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    rottens.offer(new int[]{row, col});
                }

                if (grid[row][col] == 1) {
                    freshCount++;
                }
            }
        }

        var directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        var totalTime = 0;

        while (!rottens.isEmpty()) {
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

                    if (grid[row][col] == 1) {
                        grid[row][col] = 2;
                        isRotted = true;
                        freshCount--;
                        rottens.offer(new int[] {row, col});
                    }
                }
            }

            if (isRotted) {
                totalTime++;
            }
        }

        if (freshCount > 0) {
            return -1;
        }

        return totalTime;
    }
}
