class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        var maxArea = 0;
        var visited = new boolean[grid.length][grid[0].length];

        for (var row = 0; row < grid.length; row++) {
            for (var col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1 && !visited[row][col]) {
                    var area = dfs(grid, row, col, visited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length 
            || visited[row][col] || grid[row][col] == 0) {
            return 0;
        }

        visited[row][col] = true;

        return 1 + dfs(grid, row + 1, col, visited) + dfs(grid, row - 1, col, visited)
                + dfs(grid, row, col + 1, visited) + dfs(grid, row, col - 1, visited);
        
    }
}
