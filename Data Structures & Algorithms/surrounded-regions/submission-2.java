class Solution {
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }

        var deque = new ArrayDeque<int[]>();

        for (var row = 0; row < board.length; row++) {
            if (board[row][0] == 'O') {
                board[row][0] = 'T';
                deque.offer(new int[]{row, 0});
            }
            if (board[row][board[0].length - 1] == 'O') {
                board[row][board[0].length - 1] = 'T';
                deque.offer(new int[]{row, board[0].length - 1});
            }
        }

        for (var col = 0; col < board[0].length; col++) {
            if (board[0][col] == 'O') {
                board[0][col] = 'T';
                deque.offer(new int[]{0, col});
            }
            if (board[board.length - 1][col] == 'O') {
                board[board.length - 1][col] = 'T';
                deque.offer(new int[]{board.length - 1, col});
            }
        }

        var dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        while (!deque.isEmpty()) {
            var size = deque.size();

            for (var i = 0; i < size; i++) {
                var cell = deque.poll();
            
                for (var dir : dirs) {
                    var row = cell[0] + dir[0];
                    var col = cell[1] + dir[1];

                    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
                        continue;
                    }

                    var value = board[row][col];

                    if ('O' == value) {
                        board[row][col] = 'T';
                        deque.offer(new int[]{row, col});
                    }
                }
            }
        }

        for (var row = 0; row < board.length; row++) {
            for (var col = 0; col < board[0].length; col++) {
                if ('T' == board[row][col]) {
                    board[row][col] = 'O';
                } else {
                    board[row][col] = 'X';
                }
            }
        }
    }
}
