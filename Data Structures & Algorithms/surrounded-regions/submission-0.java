class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // left and right
        for (int r = 0; r < rows; r++) {
            if(board[r][0] == 'O') {
                dfs (board, r, 0, dirs, rows, cols);
            }
            if(board[r][cols-1] == 'O') {
                dfs (board, r, cols - 1, dirs, rows, cols);
            }
        }

        for (int c = 0; c < cols; c++) {
            if(board[0][c] == 'O') {
                dfs (board, 0, c, dirs, rows, cols);
            }
            if(board[rows - 1][c] == 'O') {
                dfs (board, rows - 1, c, dirs, rows, cols);
            }
        }

        for(int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
                if(board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col, int[][] dirs, int rows, int cols) {
        board[row][col] = 'T';

        for (int[] dir : dirs){
            int newRow = dir[0] + row;
            int newCol = dir[1] + col;

            if(newRow >= 0 && newRow < rows
                && newCol >= 0 && newCol < cols
                && board[newRow][newCol] == 'O') {
                    dfs(board, newRow, newCol, dirs, rows, cols);
                }
        }
    }
}
