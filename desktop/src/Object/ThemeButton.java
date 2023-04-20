package Object;

import Helper.Button;
import Helper.Sprite;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class ThemeButton extends Button {
    public ThemeButton(int width, int height, Texture texture) {
        super(width, height, texture);

    }
    public void update(){
        if(Sprite.isLightTheme)
            setTexture(Sprite.darkTheme);
        else
            setTexture(Sprite.lightTheme);

        if((Gdx.input.getX() >= 20 && Gdx.input.getX() <= 20+128 && Gdx.input.getY() >= 75-50 && Gdx.input.getY() <= 75)) {
            if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                if (Sprite.isLightTheme) {
                    Sprite.setDarkTheme();
                    Sprite.setIsLightTheme(false);
                } else {
                    Sprite.setLightTheme();
                    Sprite.setIsLightTheme(true);
                }
            }
        }
    }
}
