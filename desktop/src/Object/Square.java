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
    private boolean isClicked;
    private boolean temp;



    public Square(){
        isOpened = false;
        isFlagged = false;
        texture = Sprite.notOpen;
        width = 32;
        height = 32;
        noFlagAround = 0;
        chording = false;
        isWrongFlagged = false;
        isClicked = false;
        temp = false;
    }


    public void update() {
        if (Gdx.input.getX() >= x && Gdx.input.getX() <= x+32-1 && Gdx.input.getY() >= Gdx.graphics.getHeight()-y-32 && Gdx.input.getY() <=  Gdx.graphics.getHeight()-y-1) {
            if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                if (!isFlagged()) {
                    if (!isOpened()) {
                        openSquare();
                        isClicked = true;
                    } else {
                        if (noFlagAround == getValue()) {
                            setChording(true);
                            isClicked = true;
                        }
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
            else if(isClicked){
                setTexture(Sprite.clickedBomb);
            }
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


    public boolean isFlagged() {
        return this.isFlagged;
    }


    public boolean isBomb() {
        if (value == -1) return true;
        return false;
    }

    public void openBomb(){
        if (!isBomb() && isFlagged) {
            isWrongFlagged = true;
        }
        if (isBomb() && !isFlagged()) {
            isOpened = true;
        }

    }


    public void openSquare(){
        if(!isOpened && !isFlagged){
            isOpened = true;
        }
    }

    public void closeSquare(){
        isOpened = false;
        setTemp(false);
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

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    public boolean isTemp() {
        return temp;
    }

    public void setTemp(boolean temp) {
        this.temp = temp;
    }
}
