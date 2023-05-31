package Object;

import Helper.Button;
import java.util.Stack;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;


public class UndoButton extends Button {
    Board board;
    protected static Square[][] gameBoard;


    public UndoButton(int width, int height, Texture texture) {
        super(width, height, texture);
    }
    public boolean update(){
        if (Gdx.input.isKeyJustPressed(Input.Keys.Z)) return true;
        if ((Gdx.input.getX() >= (Gdx.graphics.getWidth()-120) && Gdx.input.getX() <= (Gdx.graphics.getWidth()-120)+60 && Gdx.input.getY() >= 75-60 && Gdx.input.getY() <= 75))
            if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT))
                return true;
        return false;
    }

//    public void undo (){
//        if (!steps.empty()){
//            int i = (Integer)steps.pop(); //lấy giá trị nước đi gần nhất
//            Square square = gameBoard[i / board.getCol()][i % board.getRow()];
//            if (square.isOpened()){
//                square.isWhetherOpened();
////                if (square.isFlagged()){
////                    bomb--;
////                } else {
////                    bomb++;
////                }
//            }
//            if(!square.isOpened())
//            while(!steps.empty()){
//                int j = (Integer)steps.pop();
//                Square squareNext = gameBoard[j / board.getCol()][j % board.getRow()];
//            }
//        }
//    }
}