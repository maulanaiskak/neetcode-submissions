class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        var maxArea = 0;
        
        for (var row = 0; row < grid.length; row++) {
            for (var col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    var area = dfs(grid, row, col);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }


        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length - 1 || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;

        return 1 + dfs(grid, row + 1, col) + dfs(grid, row - 1, col) 
                + dfs(grid, row, col + 1) + dfs(grid, row, col - 1);
    }
}
