class Solution {
    private final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        var rows = heights.length;
        var cols = heights[0].length;
        var pac = new boolean[rows][cols];
        var atl = new boolean[rows][cols];

        for (var r = 0; r < rows; r++) {
            start(heights, r, 0, pac);
            start(heights, r, cols - 1, atl);
        }

        for (var c = 0; c < cols; c++) {
            start(heights, 0, c, pac);
            start(heights, rows - 1, c, atl);
        }

        var result = new ArrayList<List<Integer>>();
        for (var r = 0; r < rows; r++) {
            for (var c = 0; c < cols; c++) {
                if (pac[r][c] && atl[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }
        return result;
    }

    private void start(int[][] heights, int row, int col, boolean[][] visited) {
        if (visited[row][col]) {
            return;
        }
        
        visited[row][col] = true;
        dfs(heights, row, col, visited);
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] visited) {
        for (var dir : dirs) {
            var nextRow = row + dir[0];
            var nextCol = col + dir[1];

            if (nextRow < 0 || nextCol < 0 || nextRow >= heights.length || nextCol >= heights[0].length
                || visited[nextRow][nextCol] || heights[nextRow][nextCol] < heights[row][col]) {
                continue;
            }

            visited[nextRow][nextCol] = true;
            dfs(heights, nextRow, nextCol, visited);
        }
    }
}