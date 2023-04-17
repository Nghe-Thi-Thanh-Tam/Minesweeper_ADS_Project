package Object;

import java.util.Stack;

public class Board{

    public Board(int row, int col, int bomb, Square[][] board) {
        this.row = row;
        this.col = col;
        this.bomb = bomb;
        board = new Square[row][col];
        randomBomb();
        CalculateSquareValue();
    }

    private static int row = 16;
    private static int col = 16;
    private static int bomb = 40;
    static Square[][] board;

    static void randomBomb() {
        int positionX, positionY;
        int countBomb = 0;
            while (countBomb != bomb){
                positionX = (int)(Math.random()*row);
                positionY = (int)(Math.random()*col);

            if (board[positionX][positionY].getValue() != -1){
                board[positionX][positionY].setValue(-1);
                countBomb++;
            }
        }
    }

    static int checkBomb(Square[][] board, int positionX, int positionY){
        if (positionX >= 0 && positionY >=0 && positionX < row && positionY < col){
            if (board[positionX][positionY].getValue() == -1) {
                return 1;
            }
            else return 0;
        }
        return 0;
    }

    static int CalculateSquareValue(){
        int value = 0;
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (board[i][j].getValue() == -1) continue;
                else {
                    value += checkBomb(board, i-1, j-1) + checkBomb(board, i-1, j) + checkBomb(board, i-1, j+1)
                            + checkBomb(board, i, j-1) + checkBomb(board, i, j+1)
                            + checkBomb(board, i+1, j-1) + checkBomb(board, i+1, j) + checkBomb(board, i+1, j+1);

                    board[i][j].setValue(value);
                }
            }
        }
        return value;
    }

    //undo -> ctrl Z
    static void Undo(Stack s){

    }

    static void Redo(Stack s){

    }
}
