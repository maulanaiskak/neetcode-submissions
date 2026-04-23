class Solution {
    public void solve(char[][] board) {
        // Approach: reverse thinking — instead of finding surrounded regions (hard),
        // find all 'O's that are SAFE (connected to border), then capture the rest.
        //
        // Why BFS over DFS:
        // - DFS risks stack overflow on large boards (100x100 = 10k recursion depth worst case)
        // - BFS uses heap-allocated queue — safer for production, same O(mn) complexity
        //
        // Strategy:
        // 1. Seed queue with all border 'O's (they can never be captured)
        // 2. BFS outward — flood-fill all connected 'O's, mark as 'S' (safe)
        // 3. Cleanup: remaining 'O' = surrounded = flip to 'X', 'S' = restore to 'O'

        var queue = new ArrayDeque<int[]>();

        for (var row = 0; row < board.length; row++) {
            for (var col = 0; col < board[0].length; col++) {
                // Border 'O's are guaranteed safe — seed BFS from here
                // Mark on enqueue (not dequeue) to prevent duplicate enqueues
                if ((row == 0 || col == 0 || row == board.length - 1 || col == board[0].length - 1)
                        && board[row][col] == 'O') {
                    board[row][col] = 'S';
                    queue.offer(new int[]{row, col});
                }
            }
        }

        var dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            var cell = queue.poll();

            for (var dir : dirs) {
                var row = cell[0] + dir[0];
                var col = cell[1] + dir[1];

                // Bounds check — neighbor can be anywhere, not just non-border
                if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
                    continue;
                }

                // Only unvisited 'O's — 'S' already marked, 'X' irrelevant
                if (board[row][col] == 'O') {
                    board[row][col] = 'S';
                    queue.offer(new int[]{row, col});
                }
            }
        }

        // Single pass cleanup:
        // 'O' = never reached by border BFS = fully surrounded = capture
        // 'S' = connected to border = safe = restore
        // 'X' = unchanged throughout
        for (var row = 0; row < board.length; row++) {
            for (var col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }

                if (board[row][col] == 'S') {
                    board[row][col] = 'O';
                }
            }
        }
    }
}