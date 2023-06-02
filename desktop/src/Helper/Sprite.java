package Helper;

import com.badlogic.gdx.graphics.Texture;

public class Sprite {
    public static boolean isLightTheme = true;

    public static void setIsLightTheme(boolean isLightTheme) {
        Sprite.isLightTheme = isLightTheme;
    }

    public static Texture[] valueSprite = {new Texture("lightPack/value/0.png"), new Texture("lightPack/value/1.png"), new Texture("lightPack/value/2.png"),
            new Texture("lightPack/value/3.png"), new Texture("lightPack/value/4.png"), new Texture("lightPack/value/5.png"), new Texture("lightPack/value/6.png"),
            new Texture("lightPack/value/7.png"), new Texture("lightPack/value/8.png")};
    public static  Texture notOpen = new Texture("lightPack/notOpen.png");
    public static  Texture flagged = new Texture("lightPack/flagged.png");
    public static  Texture clickedBomb = new Texture("lightPack/clickedBomb.png");
    public static  Texture bomb = new Texture("lightPack/bomb.png");
    public static  Texture wrong_flagged = new Texture("lightPack/wrong_flagged.png");

    public static Texture lightTheme = new Texture("light_theme.png");
    public static Texture darkTheme = new Texture("dark_theme.png");
    public static Texture smiley_face = new Texture("smiley_face.png");
    public static Texture won_face = new Texture("won_face.png");
    public static Texture lose_face = new Texture("lose_face.png");
    public static Texture undo_button = new Texture("undo_button.png");
    public static void setValueSprite(Texture[] texture){
        valueSprite = texture;
    }
    public static void setLightTheme(){
        Texture[] tempValueSprite =  {new Texture("lightPack/value/0.png"), new Texture("lightPack/value/1.png"), new Texture("lightPack/value/2.png"),
                new Texture("lightPack/value/3.png"), new Texture("lightPack/value/4.png"), new Texture("lightPack/value/5.png"), new Texture("lightPack/value/6.png"),
                new Texture("lightPack/value/7.png"), new Texture("lightPack/value/8.png")};
        setValueSprite(tempValueSprite);
        notOpen = new Texture("lightPack/notOpen.png");
        flagged = new Texture("lightPack/flagged.png");
        clickedBomb = new Texture("lightPack/clickedBomb.png");
        bomb = new Texture("lightPack/bomb.png");
        wrong_flagged = new Texture("lightPack/wrong_flagged.png");
    }

    public static void setDarkTheme(){
        Texture[] tempValueSprite =  {new Texture("darkPack/value/0.png"), new Texture("darkPack/value/1.png"), new Texture("darkPack/value/2.png"),
                new Texture("darkPack/value/3.png"), new Texture("darkPack/value/4.png"), new Texture("darkPack/value/5.png"), new Texture("darkPack/value/6.png"),
                new Texture("darkPack/value/7.png"), new Texture("darkPack/value/8.png")};
        setValueSprite(tempValueSprite);
        notOpen = new Texture("darkPack/notOpen.png");
        flagged = new Texture("darkPack/flagged.png");
        clickedBomb = new Texture("darkPack/clickedBomb.png");
        bomb = new Texture("darkPack/bomb.png");
        wrong_flagged = new Texture("darkPack/wrong_flagged.png");
    }

}
