package Object;

import Helper.Sprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Boot;

public class Board {
    private static int row;
    private static int col;
    private static int bomb;
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

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = new Square();
            }
        }

        randomBomb();
        CalculateSquareValue();
        this.x = x;
        this.y = y;


        // set position for squares
        int squareY = y;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j].setPosition(j * 32, squareY);
            }
            squareY += 32;
        }
    }

    public void update() {
        if(lose) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    board[i][j].openBomb();
                    board[i][j].updateTexture();
                }
            }
        }
        else if(win){
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (!board[i][j].isFlagged() && board[i][j].isBomb()){
                        board[i][j].isFlagged = true;
                    }
                    board[i][j].updateTexture();
                }
            }
        }
        else{
            int leftSquare = col*row;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    updateNoFlagAround(i, j);

                    if (board[i][j].isChording()){
                        openSquareAround(i ,j);
                        board[i][j].setChording(false);
                    }
                    if (board[i][j].isOpened()){
                        if(board[i][j].getValue() == 0)
                            openSquareAround(i, j);
                        leftSquare--;

                    }
                    if (board[i][j].clickedBomb())
                        lose = true;
                    board[i][j].update();
                }
            }
            if (leftSquare == bomb)
                win = true;

        }
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j].render(batch);
            }
        }
    }



    static void randomBomb() {
        int i, j;
        int countBomb = 0;
        while (countBomb != bomb) {
            i = (int) (Math.random() * row);
            j = (int) (Math.random() * col);

            if (board[i][j].getValue() != -1) {
                board[i][j].setValue(-1);
                countBomb++;
            }
        }
    }


    static int checkBomb(int i, int j) {
        if (i >= 0 && j >= 0 && i < row && j < col) {
            if (board[i][j].isBomb()) {
                return 1;
            } else return 0;
        }
        return 0;
    }

    static void CalculateSquareValue() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!board[i][j].isBomb()){
                    int value = 0;
                    value += checkBomb(i - 1, j - 1) + checkBomb(i - 1, j) + checkBomb(i - 1, j + 1)
                            + checkBomb(i, j - 1) + checkBomb(i, j + 1)
                            + checkBomb(i + 1, j - 1) + checkBomb(i + 1, j) + checkBomb(i + 1, j + 1);

                    board[i][j].setValue(value);
                }
            }
        }
    }

    static int checkFlag(Square[][] board, int i, int j) {
        if (i >= 0 && j >= 0 && i < row && j < col) {
            if (board[i][j].isFlagged()) {
                return 1;
            } else return 0;
        }
        return 0;
    }

    static void updateNoFlagAround(int i, int j) {
        int value;
        if (!board[i][j].isBomb()) {
            value = 0;
            value += checkFlag(board, i - 1, j - 1) + checkFlag(board, i - 1, j) + checkFlag(board, i - 1, j + 1)
                    + checkFlag(board, i, j - 1) + checkFlag(board, i, j + 1)
                    + checkFlag(board, i + 1, j - 1) + checkFlag(board, i + 1, j) + checkFlag(board, i + 1, j + 1);
            board[i][j].setNoFlagAround(value);
            }
    }

    public void openSquare(int i, int j) {
        if (i >= 0 && j >= 0 && i < row && j < col) {
            board[i][j].openSquare();
        }

    }

    public void openSquareAround(int i, int j) {
        openSquare(i - 1, j - 1);
        openSquare(i - 1, j);
        openSquare(i - 1, j + 1);
        openSquare(i, j - 1);
        openSquare(i, j + 1);
        openSquare(i + 1, j - 1);
        openSquare(i + 1, j);
        openSquare(i + 1, j + 1);
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public int getBomb(){
        return bomb;
    }
}
