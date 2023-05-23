package Helper;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Stack;

public class Button {
    private int width, height;
    private Texture texture;

    public Button(int width, int height, Texture texture) {
        this.width = width;
        this.height = height;
        this.texture = texture;
    }

    public void render(int x, int y, SpriteBatch batch){
        batch.draw(texture, x, y, width, height);
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }
}
