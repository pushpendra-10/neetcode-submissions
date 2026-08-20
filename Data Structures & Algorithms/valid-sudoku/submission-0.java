class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            boolean[] row = new boolean[9];
            boolean[] col = new boolean[9];
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    int idx = board[i][j] - '1';
                    if(row[idx]) return false;
                    row[idx] = true;
                }
                if(board[j][i] != '.'){
                    int idx = board[j][i] - '1';
                    if(col[idx]) return false;
                    col[idx] = true;
                }
            }
        }

        int r = 0;
        for(int k=0; k<3; k++){
            int c=0;
            for(int l=0; l<3; l++){
                boolean[] box = new boolean[9];
                for(int i=r; i<r+3; i++){
                    for(int j=c; j<c+3; j++){
                        if(board[i][j] != '.'){
                            int idx = board[i][j] - '1';
                            if(box[idx]) return false;
                            box[idx] = true;
                        }    
                    }
                }
                c += 3;
            }
            r += 3;
        }
        return true;
    }
}