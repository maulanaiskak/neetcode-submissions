class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        var deque = new ArrayDeque<int[]>();
        for (var row = 0; row < grid.length; row++) {
            for (var col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    deque.offer(new int[]{row, col});
                }
            }
        }

        var dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        var time = 0;

        while (!deque.isEmpty()) {
            var size = deque.size();
            var rotten = false;

            for (var i = 0; i < size; i++) {
                var cell = deque.poll();
                
                for (var d : dirs) {
                    var row = cell[0] + d[0];
                    var col = cell[1] + d[1];

                    if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
                        continue;
                    }

                    if (grid[row][col] == 1) {
                        grid[row][col] = 2;
                        deque.offer(new int[]{row, col});
                        rotten = true;
                    }
                }    
            }   

            if (rotten) {
                time++;
            }         
        }

        for (var row = 0; row < grid.length; row++) {
            for (var col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    return -1;
                }
            }
        }

        return time;
    }
}
