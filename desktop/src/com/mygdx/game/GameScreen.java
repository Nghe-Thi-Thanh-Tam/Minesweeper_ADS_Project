package com.mygdx.game;

import Helper.Const;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import Object.Board;
public class GameScreen extends ScreenAdapter {
    private SpriteBatch batch;
    private Board board;

    public GameScreen(){
        board = new Board(16, 16, 4, 0, 0);
        batch = new SpriteBatch();
    }

    public void update(){
        board.update();
    }

    @Override
    public void render(float delta){
        update();
        batch.begin();

        board.render(this.batch);

        batch.end();
    }
}
