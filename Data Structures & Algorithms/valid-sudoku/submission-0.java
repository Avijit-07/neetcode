class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    char curr = board[i][j];
                    if(!set.add(curr + "seen in row" + i) ||
                        !set.add(curr + "seen in col" + j) ||
                        !set.add(curr + "seen in sub box" + i/3 + " and " + j/3))
                    return false;
                }
            }
        }
        return true;
    }
}
