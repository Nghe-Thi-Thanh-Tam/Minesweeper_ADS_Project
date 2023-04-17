package Object;

import Helper.Const;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Square {
    private int value, x, y;
    private boolean isOpened;
    private boolean isFlagged;
    private Texture texture;

    public Square(){
        isOpened = false;
        isFlagged = false;
        texture = new Texture("notOpen.png");
        x = 0;
        y = 0;
    }

    public void update() {
        if (Gdx.input.getX() >= x && Gdx.input.getX() <= x+32 && Gdx.input.getY() >= y && Gdx.input.getY() <= y+32) {
            if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                if (!isFlagged)
                    if (!isBomb())
                        if (!isOpened)
                            texture = Const.valueSprite[value];
            }
            if (Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)) {
                if (!isOpened)
                    if (!isFlagged)
                        texture = new Texture("flagged.png");
                    else
                        texture = new Texture("notOpen.png");
            }
        }
    }

    public final void render(SpriteBatch batch){
        batch.draw(texture, x, y, 32, 32);
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
