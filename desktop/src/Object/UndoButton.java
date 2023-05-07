package Object;

import Helper.Button;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import static com.badlogic.gdx.graphics.Colors.reset;

public class UndoButton extends Button {
    public UndoButton(int width, int height, Texture texture) {
        super(width, height, texture);
    }
    public boolean update(){
        if (Gdx.input.isKeyJustPressed(Input.Keys.BUTTON_Z)) return true;
        if ((Gdx.input.getX() >= (Gdx.graphics.getWidth()-60)/2 && Gdx.input.getX() <= (Gdx.graphics.getWidth()-60)/2+60 && Gdx.input.getY() >= 75-60 && Gdx.input.getY() <= 75))
            if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT))
                return true;
        return false;
    }
}