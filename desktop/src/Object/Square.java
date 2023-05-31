package Object;

import Helper.Sprite;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameScreen;

import java.util.Stack;

public class Square {
    private int value;
    private int x, y;
    private int width, height;
    private boolean isOpened;
    protected boolean isFlagged;
    private boolean isWrongFlagged;
    private Texture texture;
    private int noFlagAround;
    private boolean chording;



    public Square(){
        isOpened = false;
        isFlagged = false;
        texture = Sprite.notOpen;
        width = 32;
        height = 32;
        noFlagAround = 0;
        chording = false;
        isWrongFlagged = false;
    }


    public void update() {
        if (Gdx.input.getX() >= x && Gdx.input.getX() <= x+32 && Gdx.input.getY() >= Gdx.graphics.getHeight()-y-32 && Gdx.input.getY() <=  Gdx.graphics.getHeight()-y) {
            if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                if (!isFlagged()) {
                    if (!isOpened()) {
                        openSquare();
                    } else {
                        if (noFlagAround == getValue())
                            setChording(true);
                    }
                }
            }
            if (Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)) {
                if (!isOpened()) {
                    if (!isFlagged()) {
                        isFlagged = true;
                    } else {
                        isFlagged = false;
                    }
                }
            }
        }

        updateTexture();
    }



    public void updateTexture(){
        if (isOpened){
            if(!isBomb())
                setTexture(Sprite.valueSprite[value]);
            else{
                setTexture(Sprite.bomb);
            }
        }
        else if (!isFlagged){
            setTexture(Sprite.notOpen);
        }
        else if(!isWrongFlagged){
            setTexture(Sprite.flagged);
        }
        else{
            setTexture(Sprite.wrong_flagged);
        }
    }

//    public void repaint(){
//        setTexture(Sprite.notOpen);
//    }

    public final void render(SpriteBatch batch){
        batch.draw(texture, x, y, width, height);
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

    public boolean isWhetherOpened() {
        return this.isOpened = !isOpened;
    }

    public boolean isFlagged() {
        return this.isFlagged;
    }


    public boolean isBomb() {
        if (value == -1) return true;
        return false;
    }

    public boolean clickedBomb(){
        if (isBomb() && isOpened())
            return true;
        return false;
    }

    public void openBomb(){
        if (isBomb() && !clickedBomb() && !isFlagged())
            isOpened = true;
        if (!isBomb() && isFlagged())
            isWrongFlagged = true;
    }


    public void openSquare(){
        if(!isOpened && !isFlagged){
            isOpened = true;
        }
    }

    public void closeSquare(){
        isOpened = false;
//        setTexture(Sprite.notOpen);
    }

    public void setNoFlagAround(int noFlagAround){
        this.noFlagAround = noFlagAround;
    }
    public boolean isChording(){return chording;}
    public void setChording(boolean chording){
        this.chording = chording;
    }
    public void setTexture(Texture texture){
        this.texture = texture;
    }
}
