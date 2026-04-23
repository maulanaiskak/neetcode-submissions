class Solution {
    public int numIslands(char[][] grid) {
        var count = 0;

        for (var row = 0; row < grid.length; row++) {
            for (var col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    findIslands(grid, row, col);
                    count++;
                }
            }
        }

        return count;
    }

    private void findIslands(char[][]grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        findIslands(grid, row + 1, col);
        findIslands(grid, row - 1, col);
        findIslands(grid, row, col + 1);
        findIslands(grid, row, col - 1);
    }
}
