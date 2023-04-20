package com.mygdx.game;

import Helper.Button;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import Object.*;

public class GameScreen extends ScreenAdapter {
    private SpriteBatch batch;
    private Board board;

    private ResetButton resetButton;


    public GameScreen(){
        board = new Board(16, 16, 40, 0, 0);
        batch = new SpriteBatch();
        resetButton = new ResetButton(60, 60, new Texture("bomb.png"));
    }

    public void update() {
        board.update();
        if(resetButton.update())
            reset();
    }

    public void reset(){
        Boot.INSTANCE.create();
    }



    @Override
    public void render(float delta){
        update();
        batch.begin();

        board.render(this.batch);
        resetButton.render((Gdx.graphics.getWidth()-60)/2, Gdx.graphics.getHeight()-75, this.batch);

        batch.end();
    }
}
