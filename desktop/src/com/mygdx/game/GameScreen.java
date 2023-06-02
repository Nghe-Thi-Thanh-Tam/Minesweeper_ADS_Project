package com.mygdx.game;

import Helper.Sprite;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import Object.*;
import Object.Board;

import java.util.Stack;


public class GameScreen extends ScreenAdapter {
    private SpriteBatch batch;
    private Board board;
    private ResetButton resetButton;
    private ThemeButton themeButton;
    private UndoButton undoButton;
    private Stack<Stack> undoStack;

    public GameScreen(){

        board = new Board(16, 16, 40, 0, 0);
        batch = new SpriteBatch();
        resetButton = new ResetButton(60, 60, Sprite.smiley_face);
        themeButton = new ThemeButton(128, 50, Sprite.darkTheme);
        undoButton = new UndoButton(60, 60, Sprite.undo_button);
        undoStack = new Stack<>();
    }

    public void update() {
        board.update();
        if(board.isStateChanged()) {
                undoStack.push(board.getGameSteps());
                board.setStateChanged(false);
                board.clearGameSteps();

        }
        if(board.isWin()){
//            resetButton = new ResetButton(60, 60, Sprite.won_face);
            resetButton.setTexture(Sprite.won_face);

        }
        else if(board.isLose()){
//            resetButton = new ResetButton(60, 60, Sprite.lose_face);
            resetButton.setTexture(Sprite.lose_face);

        }
        else{
            resetButton.setTexture(Sprite.smiley_face);
        }
        themeButton.update();
        if(resetButton.update())
            reset();
        if(undoButton.update())
            undo();
    }



    public void reset(){
        Boot.INSTANCE.create();
    }

    public void undo(){
        if(!undoStack.empty()){
            if(board.isLose() || board.isWin()){
                board.setWin(false);
                board.setLose(false);
            }
            Stack<Square> tempStack = undoStack.pop();
            while(!tempStack.empty()){
                tempStack.pop().closeSquare();
            }
        }
    }



    @Override
    public void render(float delta){
        update();
        batch.begin();
        board.render(this.batch);
        resetButton.render((Gdx.graphics.getWidth()-60)/2, Gdx.graphics.getHeight()-75, this.batch);
        themeButton.render(20, Gdx.graphics.getHeight()-75, this.batch);
        undoButton.render((Gdx.graphics.getWidth()-120), Gdx.graphics.getHeight()-75, this.batch);
        batch.end();
    }

}
