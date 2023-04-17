package Object;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Square {
    private int value, x, y;
    private boolean isOpened;
    private boolean isFlagged;
    private Texture texture;

    Square(){
        isOpened = false;
        isFlagged = false;
        new Texture("\\value\\notOpen.png");
    }

    public void update() {

    }

    public final void render(SpriteBatch batch){

    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

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
        if (value == -1) return true;
        return false;
    }
}
