package Object;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Board{
    private static int row = 16;
    private static int col = 16;
    private static int bomb = 40;
    static Square[][] board;
    private int x, y;
    private boolean win, lose;
    public Board(int row, int col, int bomb, int x, int y) {
        this.row = row;
        this.col = col;
        this.bomb = bomb;
        win = false;
        lose = false;
        board = new Square[row][col];

        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                board[i][j] = new Square();
            }
        }

        randomBomb();
        CalculateSquareValue();
        this.x = x;
        this.y = y;



        // set position for squares
        int squareY = y;
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                board[i][j].setPosition(j*32, squareY);
            }
            squareY += 32;
        }
    }

    public void update(){
        if (lose)
            for (int i=0; i<row; i++){
                for (int j=0; j<col; j++){
                    board[i][j].openBomb();
                }
            }
        else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    board[i][j].update();
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j].clickedBomb())
                        lose = true;
                }
            }
        }
    }

    public void render(SpriteBatch batch){
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                board[i][j].render(batch);
            }
        }
    }



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

    static void CalculateSquareValue(){
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (board[i][j].getValue() == -1) continue;
                else {
                    int value = 0;
                    value += checkBomb(board, i-1, j-1) + checkBomb(board, i-1, j) + checkBomb(board, i-1, j+1)
                            + checkBomb(board, i, j-1) + checkBomb(board, i, j+1)
                            + checkBomb(board, i+1, j-1) + checkBomb(board, i+1, j) + checkBomb(board, i+1, j+1);

                    board[i][j].setValue(value);
                }
            }
        }
    }
}
