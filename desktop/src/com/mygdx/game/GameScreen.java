package com.mygdx.game;

import Helper.Const;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import Object.Board;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
public class GameScreen extends ScreenAdapter {
    private SpriteBatch batch;
    private Board board;

    private Texture texture;



    public GameScreen(){
        board = new Board(16, 16, 4, 0, 0);
        batch = new SpriteBatch();
    }

    public void update(){
        board.update();
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) reset();
        if ((Gdx.input.getX() >= 220 && Gdx.input.getX() <= 220+60 && Gdx.input.getY() >= Gdx.graphics.getHeight()-525-60 && Gdx.input.getY() <=  Gdx.graphics.getHeight()-525))
            if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT))
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

        batch.end();
    }
}
