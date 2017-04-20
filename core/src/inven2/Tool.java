package inven2;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.game.MyGdxGame;

/**
 * Created by 256233 on 4/11/2017.
 */
public class Tool {

    public void setFoodrestored(int foodrestored) {
        this.foodrestored = foodrestored;
    }

    public void setWaterrestored(int waterrestored) {
        this.waterrestored = waterrestored;
    }

    int foodrestored;
     int waterrestored;

    public void setHealthrestored(int healthrestored) {
        this.healthrestored = healthrestored;
    }

    int healthrestored;


    public  void setImage(Texture image) {
        this.image = new Sprite(image);
    }

    Sprite image;

    public void setDamage(int damage) {
        this.damage = damage;
    }


    int damage;
    public  int getFoodrestored()
    {
        return foodrestored;
    }
    public  int getWaterrestored()
    {
        return waterrestored;
    }
    public  int getHealthrestored()
    {
        return healthrestored;
    }
    public  int getDamage()
    {
        return damage;
    }
    public  Sprite getImage()
    {
        return image;
    }

}
