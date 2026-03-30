class Solution {
    public boolean exist(char[][] board, String word) {
        // only start the grid traversal if the letter matches
        // i.e. if char[0][0] == word[0]
        // char[x][y] == word[z]

        // break the recursion once the length == word length 
        // && words are equal

        int height = board.length;
        int width = board[0].length;

        for(int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if(backtrack(board, word, r, c, 0)) return true;
            }
        }

        return false;

    }

    private boolean backtrack(char[][] board, String word, int row, int col, int index) {
        int height = board.length;
        int width = board[0].length;

        if(index == word.length()) return true;

        if(row < 0 || row >= height || col < 0 || col >= width) return false;

        if(board[row][col] == '#') return false;

        if(board[row][col] != word.charAt(index)) return false;

        char orig = board[row][col];

        board[row][col] = '#';

        boolean found = backtrack(board, word, row + 1, col, index + 1) ||
                            backtrack(board, word, row - 1, col, index + 1) ||
                            backtrack(board, word, row, col + 1, index + 1) ||
                            backtrack(board, word, row, col - 1, index + 1);

        board[row][col] = orig;

        return found;
    }
}
