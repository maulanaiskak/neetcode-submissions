class Solution {
    private static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        var rows = heights.length;
        var cols = heights[0].length;

        var pacificSources = new ArrayList<int[]>();
        var atlanticSources = new ArrayList<int[]>();

        for (var row = 0; row < rows; row++) {
            pacificSources.add(new int[]{row, 0});
            atlanticSources.add(new int[]{row, cols - 1});
        }

        for (var col = 0; col < cols; col++) {
            pacificSources.add(new int[]{0, col});
            atlanticSources.add(new int[]{rows - 1, col});
        }

        var pacific = bfs(heights, pacificSources);
        var atlantic = bfs(heights, atlanticSources);
        var result = new ArrayList<List<Integer>>();

        for (var row = 0; row < rows; row++) {
            for (var col = 0; col < cols; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    result.add(List.of(row, col));
                }
            }
        }

        return result;
    }

    private boolean[][] bfs(int[][] heights, List<int[]> sources) {
        var visited = new boolean[heights.length][heights[0].length];
        var deque = new ArrayDeque<int[]>();

        for (var source : sources) {
            visited[source[0]][source[1]] = true;
            deque.offer(source);
        }

        while (!deque.isEmpty()) {
            var cell = deque.poll();

            for (var d : dirs) {
                var row = cell[0] + d[0];
                var col = cell[1] + d[1];

                if (row < 0 || col < 0 || row >= heights.length 
                    || col >= heights[0].length || visited[row][col]) {
                    continue;
                }

                if (heights[row][col] >= heights[cell[0]][cell[1]]) {
                    visited[row][col] = true;
                    deque.offer(new int[]{row, col});
                }
            }
        }

        return visited;
    }
}