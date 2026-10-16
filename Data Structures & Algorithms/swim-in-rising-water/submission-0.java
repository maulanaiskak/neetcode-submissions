class Solution {
    public int swimInWater(int[][] grid) {
        var queue = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[2]));
        queue.offer(new int[] {0, 0, grid[0][0]});

        var directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        var visited = new boolean[grid.length][grid[0].length];

        while (!queue.isEmpty()) {
            var data = queue.poll();
            var row = data[0];
            var col = data[1];
            var time = data[2];

            if (visited[row][col]) {
                continue;
            }

            visited[row][col] = true;

            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return time;
            }

            for (var dir : directions) {
                var nextRow = row + dir[0];
                var nextCol = col + dir[1];
                
                if (nextRow < 0 || nextCol < 0 || nextRow >= grid.length || nextCol >= grid[0].length || visited[nextRow][nextCol]) {
                    continue;
                }

                var nextTime = Math.max(time, grid[nextRow][nextCol]);
                queue.offer(new int[] {nextRow, nextCol, nextTime});
            }
        }

        return -1;
    }
}
