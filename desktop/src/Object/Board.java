package Object;

public class Board extends Square{

    private static int row = 16;
    private static int col = 16;
    private static int bomb = 10;
    private static int countBomb;
    static void randomBomb(int board[][]) {
        int x, y;
            while (countBomb != bomb){
            x = (int)(Math.random()*row);
            y = (int)(Math.random()*col);

            if (board[x][y] != -1){
                board[x][y] = -1;
                countBomb++;
            }
        }
    }

    static int checkBomb(int[][] board, int x, int y){
        if (x >= 0 && y >=0 && x < row && y < col){
            if (board[x][y] == -1) {
                return 1;
            }
            else return 0;
        }
        return 0;
    }

    static int CalculateSquareValue(int board[][]){
        int value = 0;
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (board[i][j] == -1) continue;
                else {
                    value += checkBomb(board, i-1, j-1) + checkBomb(board, i-1, j) + checkBomb(board, i-1, j+1)
                            + checkBomb(board, i, j-1) + checkBomb(board, i, j+1)
                            + checkBomb(board, i+1, j-1) + checkBomb(board, i+1, j) + checkBomb(board, i+1, j+1);
                    board[i][j] = value;
                }
            }
        }
        return value;
    }
}
