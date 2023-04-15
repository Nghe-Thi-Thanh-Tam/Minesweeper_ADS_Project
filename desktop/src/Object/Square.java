package Object;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Square {
    int value;
    boolean isOpened;
    boolean isFlagged;
    boolean isBomb;
    Texture texture;

    public void Square(){

    }

    public void update() {
    }

//    public final void render(SpriteBatch){
//
//    }

    public int getValue() {
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public boolean isOpened() {
        return this.isOpened;
    }

    public boolean isFlagged() {
        return this.isFlagged;
    }

    public boolean isBomb() {
        return this.isBomb;
    }
}
